# coding: utf-8
import jieba
import jieba.analyse
import gensim
import logging
from gensim.models import word2vec
from sklearn import feature_extraction
from sklearn.feature_extraction.text import TfidfVectorizer
from langconv import *
from random import randint
from SolrClient import SolrClient
solr = SolrClient('http://localhost:8983/solr')
jieba.set_dictionary('dict.txt.big.txt')

def tradition2simple(line): 
    line = Converter('zh-hans').convert(line)  
    line = line.encode('utf-8')  
    return line

def simple2tradition(line):
    line = Converter('zh-hant').convert(line)  
    line = line.encode('utf-8')  
    return line

def bot_say_hello():
    ran = randint(0,2)
    helloList = ["哈囉! 你好啊", "嗨, 今天過得如何?", "很高興見到你~"]
    print("Bot: " + helloList[ran])
    return

def bot_say_goodbye():
    ran = randint(0,2)
    goodbyeList = ["拜拜! 後會有期", "再見! 祝你有美好的一天", "下次再來玩喔~"]
    print("Bot: " + goodbyeList[ran] + "\n")
    return

def bot_no_result():
    ran = randint(0,2)
    errorList = ["對不起! 我聽不懂你說的話", "不好意思... 能換句話說嗎?", "抱歉, 我無法理解"]
    print("Bot: " + errorList[ran])
    return

print("\n\n*********************************")
print("Welcome to solr chatbot!\n")
print("Input \"goodbye\" to leave\n")
print("Now say something! Enjoy!")
print("*********************************\n")
bot_say_hello()

while True:
    scoreMax = 0
    resultList = []
    talk_tc = input("You: ")
    if(talk_tc == "goodbye"):
        bot_say_goodbye()
        print("*********************************\n\n")
        break;

    talk_sc = tradition2simple(talk_tc).decode('utf8')
    
    res = solr.query('gettingstarted',{
          "q":talk_sc,
          "indent":"on",
          "rows":"100",
          "wt":"json",
          "_":"1489491381200"}
        )
    
    try:
        for i in range(100):
            talk_cut = jieba.cut(talk_sc, cut_all=False)
            bot_talk_sc = ''.join(res.docs[i]['cmnt_content'])
            bot_talk_cut = jieba.cut(bot_talk_sc, cut_all=False)
            score = 0
            for user_word in talk_cut:
                for bot_word in bot_talk_cut:
                    try:
                        score = score + model.similarity(user_word, bot_word)
                    except:
                        score = score #ignore exceptions        
            resultList.append([score,bot_talk_sc])
        resultList.sort()
        resultList.reverse()
        for i in range(3):
            print("Bot: " + resultList[i][1])
    except:
        bot_no_result()
    
