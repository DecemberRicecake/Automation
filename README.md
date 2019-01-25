# Automation

## Cucumber doc
[cucumber-jvm](https://cucumber.io/)  
[selenium](http://www.seleniumframework.com/)  


## Cucumber examples
[CucumberJVMExamples](https://github.com/machzqcq/CucumberJVMExamples)  
[cucumber-jvm](https://github.com/cucumber/cucumber-jvm/tree/master/examples)  


## Quickstart  
1. pom.xml添加依赖  
2. 创建 feature 文件  

    | en               | zn                 |
    | ---------------- | ------------------ |
    | feature          | 功能               |
    | background       | 背景               |
    | scenario         | 场景, 剧本         |
    | scenario outline | 场景大纲, 剧本大纲 |
    | examples         | 例子               |
    | given            | 假如, 假设, 假定   |
    | when             | 当                 |
    | then             | 那么               |
    | and              | 而且, 并且, 同时   |
    | but              | 但是               |


3. 编写Step Definition  
4. 创建JUnit Test运行类    [RunCukesTest](src/test/java/RunCukesTest.java)  
5. 运行  
    `mvn verify`, 在 *target/reports* 目录下就可以浏览生成的报告  
    ![report_feature.png](picture/report_feature.png)   
    



