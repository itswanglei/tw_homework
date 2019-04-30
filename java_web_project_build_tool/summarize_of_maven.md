# Maven 相关概念总结

## 构建原理

Maven 构建项目的规则是`约定大于配置`，约定指 Maven 提倡项目应遵循标准的目录结构、命名规范等，以便于 Maven 帮助用户自动化地完成项目的编译、测试、打包等一系列工作。

Maven 对项目的生命周期进行了规范，保证不同用户按照统一的规范实现项目的自动化构建。

## 生命周期

Maven 项目的生命周期包含三部分：Clean、Build、Site

### Clean 生命周期

Clean 生命周期用于在项目正式构建前进行一些清理工作，包含以下阶段：

- pre-clean：执行 clean 前需要完成的工作
- clean：清理上次构建生成的文件
- post-clean：执行 clean 后需要完成的工作

### Build 生命周期

Build 生命周期用于构建项目，是 Maven 项目的主要生命周期，共包含23个阶段，主要的有：

- validate：验证项目正确且必要的信息可用
- compile：编译代码
- test：执行单元测试
- package：打包编译后的代码
- verify：运行集成测试以保证项目质量达标
- install：将打包后的项目安装至本地仓库以供其他项目使用
- deploy：在build环境上部署项目，并将打包后的项目发送到远程仓库

### Site 生命周期

Site 生命周期用于生成项目的报告文档、站点，包含以下阶段：

- pre-site：执行生成站点文档前的工作
- site：生成站点文档
- post-site：执行生成站点文档后的工作，并未部署做准备
- site-deploy：将生成的站点文档部署到服务器上

## 配置文件

Maven 项目的配置文件为项目根目录下的`pom.xml`文件，该文件中主要包含以下几部分：

- `groupId`和`artifactId`标签分别表示组织/公司的标识和项目的标识，这两个 id 共同定义了这个项目在 Maven 仓库中的唯一坐标
- `version`标签表示项目的版本信息
- `build`标签用于定义项目的构建过程
- `dependency`标签用于定义项目依赖的外部库
- `repositories`标签用于定义项目的远程仓库

例如：

- 基本配置：

```xml
<!-- 组织标识 -->
<groupId>org.apache.maven.extensions</groupId>
<!-- 项目标识 -->
<artifactId>beer-maven-lifecycle</artifactId>
<!-- 项目版本号 -->
<version>1.0-SNAPSHOT</version>

<!-- 项目的依赖 -->  
<dependencies> 
    <dependency>
        <groupId>org.apache.maven</groupId>
        <artifactId>maven-core</artifactId>
        <version>3.6.1</version>
    </dependency>

    <dependency>
        <groupId>org.codehaus.plexus</groupId>
        <artifactId>plexus-component-annotations</artifactId>
        <version>1.7.1</version>
    </dependency>
</dependencies>  

<!-- 项目的远程仓库 --> 
<repositories>
  <repository>
    <id>companyname.lib1</id>
    <url>http://download.companyname.org/maven2/lib1</url>
  </repository>
</repositories>
```

- 构建配置：

```xml
<build>  

    <!-- 构建出的文件名，默认值是${artifactId}-${version}。 -->  
    <finalName>myPorjectName</finalName>  

    <!-- 构建产生的所有文件存放的目录,默认为项目根目录下的target -->  
    <directory>${basedir}/target</directory>  

    <!-- 项目相关的所有资源路径列表 -->  
    <resources>  
        <resource>  
            <!-- 描述了资源的目标路径 -->  
            <targetPath>resources</targetPath>  

            <!-- 描述存放资源的目录，该路径相对POM路径 -->  
            <directory>src/main/resources</directory>  

            <!-- 包含的模式列表 -->  
            <includes>  
                <include>**/*.properties</include>  
                <include>**/*.xml</include>  
            </includes>  

            <!-- 排除的模式列表 如果<include>与<exclude>划定的范围存在冲突，以<exclude>为准 -->  
            <excludes>  
                <exclude>jdbc.properties</exclude>  
            </excludes>  

        </resource>  
    </resources>  

    <!-- 单元测试相关的所有资源路径，配制方法与resources类似 -->  
    <testResources>  
        <testResource>  
        </testResource>  
    </testResources>  

    <!-- 项目源码目录，相对于pom.xml路径 -->  
    <sourceDirectory>${basedir}\src\main\java</sourceDirectory>  

    <!-- 项目单元测试使用的源码目录相对于pom.xml路径 -->  
    <testSourceDirectory>${basedir}\src\test\java</testSourceDirectory>  

    <!-- 项目的一系列构建扩展 -->  
    <extensions>  
        <extension>  
            <groupId>org.apache.maven.wagon</groupId>  
            <artifactId>wagon-ssh</artifactId>  
            <version>2.8</version>  
        </extension>  
    </extensions>  

    <!-- 使用的插件列表  -->  
    <plugins>  
        <plugin>  
            <groupId></groupId>  
            <artifactId>maven-assembly-plugin</artifactId>  
            <version>2.5.5</version>  

            <!-- 在构建生命周期中执行一组目标的配置 -->  
            <executions>  
                <execution>  
                    <!-- 执行目标的标识符 -->  
                    <id>assembly</id>  

                    <!-- 绑定了目标的构建生命周期阶段 -->  
                    <phase>package</phase>  

                    <!-- 配置的执行目标 -->  
                    <goals>  
                        <goal>single</goal>  
                    </goals>  
                </execution>  
            </executions>  

            <!-- 项目引入插件所需要的额外依赖 -->  
            <dependencies>  
                <dependency>...</dependency>  
            </dependencies>  
        </plugin>  
    </plugins>  
</build>  
```

## 仓库

Maven 仓库用于存储项目的依赖文件，分为本地仓库、远程仓库和中央仓库

- 本地仓库

  本地仓库位于开发人员自己的计算机上，保存着项目的所有依赖。在运行 Maven 构建时，Maven 会自动将所有依赖下载到本地仓库以供使用。

  Maven 本地仓库默认被创建在` %USER_HOME%` 目录下。可以在 `%M2_HOME%\conf `目录中的`settings.xml`中修改

- 中央仓库

  中央仓库由 Maven 社区提供，包含大量的常用库，通过网络进行访问，不需要进行配置。

- 远程仓库

  远程仓库由项目组织定义，需要通过项目的 `pom xml`文件进行配置，

## 参考

- [Maven的安装、配置及使用入门](<https://www.cnblogs.com/dcba1112/archive/2011/05/01/2033805.html>)
- [Maven之pom.xml配置文件详解](<https://blog.csdn.net/qq_33363618/article/details/79438044>)