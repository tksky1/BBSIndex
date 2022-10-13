# BBSIndex
A scrawler project for MCBBS static based on SpringBoot, Jsoup and Echats.  
本项目是一个基于jsoup和springboot的后端+爬虫项目，利用echarts在页面展示简单的统计图。  

爬虫会爬取mcbbs服务器版的公开数据并进行储存和简单处理，生成：
1. 服务器总数趋势图
2. 服务器指数（服务器增速）
3. 论坛指数（浏览量增速）

三幅统计图。本项目将部署在 http://mcbbs.mcyou.cc 以供查阅。同时在/charts/ 提供REST服务。