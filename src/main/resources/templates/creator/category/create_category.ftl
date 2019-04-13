<#ftl encoding='UTF-8'>
<!DOCTYPE html>
<html>
     <#include "../../head.ftl">
<body>
<#include "../../header.ftl">
<div class="container-fluid">
    <div class="row">
        <div class="col-md-1 col-lg-2 col-xs-3">

        </div>
        <div class="col-12 col-sm-12 col-md-10 col-lg-8 col-xs-6">
            <div style="text-align: center">
                <h2>Создание категории</h2>
            </div>
            <div class="form-group" style="padding-top: 10px">
                <a href="all"><button class="btn btn-secondary">Назад</button></a>
            </div>
            <form action="" method='POST'>
                <div class="form-group">
                    <#if error??>
                        <div class="alert alert-danger" role="alert">${error}</div>
                    </#if>
                </div>
                <div class="form-group">
                    <#if success??>
                        <div class="alert alert-success" role="alert">${success}</div>
                    </#if>
                </div>

                <#if model.category??>
                    <div class="form-group">
                        <label for="inputId">Id</label>
                        <input value="${model.category.id}" name="id" class="form-control" disabled id="inputId"
                               placeholder="Id"/>
                    </div>
                </#if>

                <div class="form-group">
                    <label for="inputName">Введите название категории</label>
                    <input name="name" class="form-control" id="inputName" placeholder="Имя"
                           value="${model.category???then(model.category.name?html, "")}"/>
                </div>

                <div class="form-group">
                    <input type="submit" value="${model.category???then("Изменить", "Добавить")}" class="form-control"
                           id="inputSubmit"/>
                </div>
            </form>
        </div>
        <div class="col-md-1 col-lg-2 col-xs-3">

        </div>
    </div>
</div>

<#include "../../footer.ftl">
</body>
</html>
