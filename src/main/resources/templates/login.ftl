<#ftl encoding='UTF-8'>

<!DOCTYPE html>
<html>
     <#include "head.ftl">
<body>

<#include "header.ftl">

<div class="container-fluid">
    <div class="row">
        <div class="col-md-1 col-lg-2 col-xs-3">

        </div>
        <div class="col-12 col-sm-12 col-md-10 col-lg-8 col-xs-6">
            <form action="login" method='POST'>
                <div class="form-group">
                    <#if model.error.isPresent()>
                        <div class="alert alert-danger" role="alert">Логин или пароль введены неверно</div>
                    </#if>
                </div>
                <#if success??>
                    <div class="form-group">
                        <div class="alert alert-success" role="alert">${success}</div>
                    </div>
                </#if>
                <div class="form-group">
                    <label for="inputLogin">Введите логин</label>
                    <input name="login" type="text" class="form-control" id="inputLogin" placeholder="Логин">
                </div>

                <div class="form-group">
                    <label for="inputLogin">Введите пароль</label>
                    <input name="password" type="password" class="form-control" id="inputPassword" placeholder="Пароль">
                </div>
                <div class="form-group">
                    <input class="form-control" type="submit" value="Авторизоваться">
                </div>
            </form>
            <div class="card">
                <div class="card-body">
                    <p class="card-text">Всё ещё не зарегистрированы? <a href="sign-up">Регистрация</a></p>
                    <p class="card-text">Забыли пароль? <a href="restore">Востановление</a></p>

                </div>
            </div>
        </div>
        <div class="col-md-1 col-lg-2 col-xs-3">

        </div>
    </div>
</div>

<#include "footer.ftl">
</body>
</html>
