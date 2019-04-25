

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
                <h2>Скидки <a href="create"><button class="btn btn-sm btn-primary">+</button></a></h2>
            </div>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Код</th>
                    <th scope="col">Скидка</th>
                    <th scope="col">Действия</th>
                </tr>
                </thead>
                <tbody>
                <#list model.discounts as discount>
                <tr>
                    <th scope="row"><a href="${'create?id=' + discount.id}">${discount.id!}</a></th>
                    <td>${discount.code?html}</td>
                    <td>${discount.salePercent?c}</td>
                    <td><a href="${'create?id=' + discount.id}">Изменить</a>
                        <a href="${'delete/' + discount.id}">Удалить</a>
                    </td>
                </tr>
                </#list>
                </tbody>
            </table>

            <nav aria-label="navigation">
                <ul class="pagination justify-content-center">
                    <li class="page-item ${((model.currentPage == 0)?string("disabled",""))}">
                        <a class="page-link" href="?page=${model.currentPage - 1}" tabindex="-1">Previous</a>
                    </li>

                    <#list model.pageList as page>
                        <li class="page-item ${((page == model.currentPage)?string("active",""))}">
                            <a class="page-link" href="?page=${page}">
                                ${page}
                            </a>
                        </li>
                    </#list>

                    <li class="page-item
                        ${((model.pageList?size <= 0 || model.currentPage == model.pageList[model.pageList?size - 1])?string("disabled",""))}
                        ">
                        <a class="page-link" href="?page=${model.currentPage + 1}">Next</a>
                    </li>
                </ul>
            </nav>
        </div>
        <div class="col-md-1 col-lg-2 col-xs-3">

        </div>
    </div>
</div>

<#include "../../footer.ftl">
</body>
</html>
