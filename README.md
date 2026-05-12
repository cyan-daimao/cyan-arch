# cyan-arch

> **Cyan 数据平台体系基础依赖 / 公共组件库（Parent POM）**

[![Java](https://img.shields.io/badge/Java-21-orange?logo=openjdk)](https://openjdk.org/)
[![Maven](https://img.shields.io/badge/Maven-3.9+-blue?logo=apachemaven)](https://maven.apache.org/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.13-brightgreen?logo=springboot)](https://spring.io/projects/spring-boot)
[![Spring Cloud](https://img.shields.io/badge/Spring%20Cloud-2023.0.6-brightgreen?logo=spring)](https://spring.io/projects/spring-cloud)
[![Spring Cloud Alibaba](https://img.shields.io/badge/Spring%20Cloud%20Alibaba-2023.0.3.4-orange?logo=alibabadotcom)](https://sca.aliyun.com/)
[![Nacos](https://img.shields.io/badge/Nacos-2.3.0-blue?logo=alibabadotcom)](https://nacos.io/)
[![MyBatis Plus](https://img.shields.io/badge/MyBatis%20Plus-3.5.7-red)](https://baomidou.com/)
[![MySQL](https://img.shields.io/badge/MySQL-8.3.0-blue?logo=mysql)](https://www.mysql.com/)
[![Hutool](https://img.shields.io/badge/Hutool-5.8.25-green)](https://hutool.cn/)
[![MapStruct](https://img.shields.io/badge/MapStruct-1.5.5.Final-lightgrey)](https://mapstruct.org/)
[![Lombok](https://img.shields.io/badge/Lombok-1.18.42-critical?logo=lombok)](https://projectlombok.org/)
[![Logback](https://img.shields.io/badge/Logback-1.5.20-yellow)](https://logback.qos.ch/)

---

## 📖 项目简介

`cyan-arch` 是 **Cyan 数据平台体系** 的顶层基础依赖库（Parent POM），为所有业务服务提供统一的依赖管理和公共组件封装。

本项目采用 **Maven 多模块** 结构，通过 `dependencyManagement` 集中管控各组件版本，确保全链路依赖版本一致性，避免子工程版本冲突。所有 Cyan 体系下的微服务均以此 POM 为父级依赖。

## 🛠 技术栈

| 技术 | 版本 | 说明 |
|------|------|------|
| Java | 21 | 运行与编译版本 |
| Spring Boot | 3.3.13 | 应用框架 |
| Spring Cloud | 2023.0.6 | 微服务治理 |
| Spring Cloud Alibaba | 2023.0.3.4 | 阿里微服务套件 |
| Nacos | 2.3.0 | 注册中心 / 配置中心 |
| MyBatis Plus | 3.5.7 | ORM 增强 |
| MySQL Connector | 8.3.0 | 数据库驱动 |
| Hutool | 5.8.25 | Java 工具类库 |
| MapStruct | 1.5.5.Final | 对象映射转换 |
| Lombok | 1.18.42 | 代码生成 |
| Logback | 1.5.20 | 日志框架 |
| JUnit | 5.10.2 | 单元测试 |

## 📦 模块说明

```
cyan-arch/
├── pom.xml              # Parent POM：统一版本管控、依赖管理
├── arch-common/         # 公共工具类模块
│   ├── lombok           # 代码简化
│   └── jackson-databind # JSON 处理
└── arch-base/           # 基础框架封装模块
    ├── spring-boot-starter-web      # Web 容器
    ├── spring-boot-starter-actuator # 服务监控端点
    ├── spring-cloud-starter-bootstrap           # 引导配置
    ├── spring-cloud-starter-alibaba-nacos-discovery   # Nacos 服务发现
    ├── spring-cloud-starter-alibaba-nacos-config        # Nacos 配置中心
    ├── spring-cloud-starter-openfeign                 # 声明式 HTTP 客户端
    ├── spring-cloud-starter-loadbalancer              # 负载均衡
    ├── spring-boot-starter-validation                 # 参数校验
    ├── mapstruct / mapstruct-processor                # 类型转换
    ├── logback                                          # 日志
    └── arch-common                                    # 依赖公共模块
```

| 模块 | ArtifactId | 说明 |
|------|-----------|------|
| **arch-common** | `com.cyan:arch-common` | 公共工具类，提供无 Spring 依赖的通用工具 |
| **arch-base** | `com.cyan:arch-base` | 基础框架封装，集成 Spring Boot、Nacos、Feign、Validation 等 |

> 💡 **使用建议**：业务服务通常直接依赖 `arch-base` 即可，`arch-base` 内部已包含 `arch-common`。

## 🚀 快速开始

### 1. 本地安装

```bash
git clone git@github.com:cyan-daimao/cyan-arch.git
cd cyan-arch
mvn clean install
```

### 2. 在业务服务中引入

作为 **Parent POM** 使用：

```xml
<parent>
    <groupId>com.cyan</groupId>
    <artifactId>arch</artifactId>
    <version>1.0-SNAPSHOT</version>
</parent>
```

或直接引用子模块（推荐在 `arch` 已作为 parent 的场景下）：

```xml
<dependencies>
    <dependency>
        <groupId>com.cyan</groupId>
        <artifactId>arch-base</artifactId>
    </dependency>
</dependencies>
```

> 子模块版本由 Parent POM 的 `dependencyManagement` 统一锁定，无需显式指定 `<version>`。

## 📤 部署

本项目配置了 Nexus 私有仓库，执行以下命令即可发布：

```bash
# 快照版
mvn clean deploy

# 正式版（需修改 version 为 RELEASE）
mvn clean deploy -Prelease
```

- **Release 仓库**：`http://nexus.cyan.com/repository/maven-releases/`
- **Snapshot 仓库**：`http://nexus.cyan.com/repository/maven-snapshots/`

## 📄 License

本项目为 Cyan 内部基础组件库，仅供组织内部使用。
