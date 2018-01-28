# Cloud-Paint
A simple cloud paint

一、	程式簡介

這是一個可以多人共同協作的簡易共筆小畫家，功能有：

1.	筆刷工具
2.	直線工具
3.	矩形工具
4.	橢圓工具
5.	填滿工具
6.	清空畫布
7.	調色盤工具
8.	畫筆尺寸設定（大、中、小）

我們會預先架好一個Server，使用者可以離線使用小畫家，或是按下Connection選單中的connect，連上Server後，即可和他人共同協作小畫家。

二、	程式架構

共筆小畫家分為四個.java檔，分別為：

1.	CloudPaint.java：小畫家本體
2.	ClientPaintListenThread.java：用來監聽來自Server的訊息，也就是其他使用者繪製的資訊（畫筆種類、尺寸、顏色與座標等等）
3.	ServerTest.java：Server本體，用來接收Client的連線，並分給每個Client一個Thread。
4.	ServerListenThread.java：用來接收使用者繪製的資訊，並傳送給所有其他的使用者，每一個使用者都會被分到一個Thread。
