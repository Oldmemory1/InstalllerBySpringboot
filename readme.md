### 项目功能：使用Springboot打包文件，默认服务端口号8192，部署后运行，访问http://localhost:8192即可看到结果
# Chapter1:使用教程

## 1.1运行环境配置

### 操作系统：建议使用Ubuntu20.04或Windows10-22H2
### 操作系统的Java版本：建议使用17.0.12以上的JDK版本
### 安装HexEditor Neo等二进制文件查看器软件用于拆分文件 安装包地址:https://hhdsoftware.com/free-hex-editor

## 1.2项目配置

### 使用IDEA打开本项目，本项目适用于将一个大的压缩包使用HexEditor Pro拆分为3个bin文件后，再次封装，同时，携带用户修改后的二进制合并器merger

### 项目的application.properties的server.port字段决定了服务器开启的端口号，如果遇到端口冲突，请把端口号自增1，改为8193，若仍然冲突，请重复自增修改操作

### 项目的resources/files文件夹是存放要下载的文件，如果不想要修改org.example.installerbyspringboot.Component.Utility.java文件的值注解，请在resources/files文件夹中存放拆分后的3个bin文件，分别命名为part1.bin part2.bin part3.bin

### 
