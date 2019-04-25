<#ftl encoding='UTF-8'>

<!DOCTYPE html>
<html>
     <#include "../head.ftl">
<body>

<#include "../header.ftl">

<div class="container-fluid">
    <div class="row">
        <div class="col-md-1 col-lg-2 col-xs-3">

        </div>
        <div class="col-12 col-sm-12 col-md-10 col-lg-8 col-xs-6">
            <form action="" method='POST'>
                <div class="form-group text-center">
                    <h4>Востановление пароля</h4>
                </div>

                <div class="form-group">
                    <#if error??>
                        <div class="alert alert-danger" role="alert">${error}</div>
                    </#if>
                </div>
                <div class="form-group">
                    <#if success??>
                        <div class="alert alert-success" role="success">${success}</div>
                    </#if>
                </div>
                <div class="form-group">
                    <label for="inputLogin">Введите логин</label>
                    <input name="login" type="text" class="form-control" id="inputLogin" placeholder="Логин">
                </div>

                <div class="form-group">
                    <input class="form-control" type="submit" value="Востановить пароль">
                </div>
            </form>
        </div>

        <div class="col-md-1 col-lg-2 col-xs-3">

        </div>
    </div>
</div>

<#include "../footer.ftl">
</body>
</html>
