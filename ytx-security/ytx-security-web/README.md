ytx-security-web
==============================
### security 运行过程
    ExceptionTranslationFilter->FilterSecurityInterceptor
    验证是否登录，没登录跳转UsernamePasswordAuthenticationFilter
### 自定义用户认证逻辑
    UserDetailService
    UserDetail
    PasswordEncoder
### 认证流程

### 登录方式
    前后端分离，直接Ajax请求登录，返回json数据： http://localhost:8080/authentication/form
    前后端不分离，后端引导登录页面： http://localhost:8080/login.html
### 指定配置信息