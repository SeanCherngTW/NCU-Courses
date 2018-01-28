# coding: utf-8

import jieba
jieba.set_dictionary('dict.txt.big.txt')
content = open('weiboDoc.txt', 'rb').read()
words = jieba.cut(content, cut_all=False)
print ("START!")

text_file = open("OutputBig.txt", "w")
for word in words:
    text_file.write(word+' ')
    
text_file.close()
print ("DONE!")
from gensim.models import word2vec
import logging
logging.basicConfig(format='%(asctime)s : %(levelname)s : %(message)s', level=logging.INFO)
sentences = word2vec.Text8Corpus('OutputBig.txt')
model = word2vec.Word2Vec(sentences, size=200)
model.save('weibo_Word2Vec_big')
