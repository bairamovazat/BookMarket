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
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">Название</th>
                    <th scope="col">Автор</th>
                    <th scope="col">Категория</th>
                    <th scope="col">Издательство</th>
                </tr>
                </thead>
                <tbody>
                <#list model.books as book>
                <tr>
                    <td>${book.name!}</td>
                    <td>${book.author!}</td>
                    <td>${book.category???then(book.category.name!, "")}</td>
                    <td>${book.publisher???then(book.publisher.name!, "")}</td>
                </tr>
                </#list>
                </tbody>
            </table>
        </div>
        <div class="col-md-1 col-lg-2 col-xs-3">

        </div>
    </div>
</div>

<#include "../../footer.ftl">
</body>
</html>
