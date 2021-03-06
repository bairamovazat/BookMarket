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
            <table class="table table-striped">
                <thead>
                <tr>
                <#--<th scope="col">#</th>-->
                    <th scope="col">Адрес</th>
                    <th scope="col">Статус</th>
                    <th scope="col">Оплата после доставки</th>
                    <th scope="col">Дата создания</th>
                    <th scope="col">Цена</th>
                    <th scope="col">Скидка</th>
                </tr>
                </thead>
                <tbody>
                <#list model.orders as order>
                <tr>
                <#--<th scope="row"><a href="${'create?id=' + order.id}">${order.id!}</a></th>-->
                    <td>${order.address!}</td>
                    <td>${order.status!}</td>
                    <td>${order.payAfterDelivery???string("Да", "Нет")}</td>
                    <td>${order.createDate!}</td>
                    <td>${order.price!} Руб</td>
                    <td>${order.salePercent???then(order.salePercent + "%", "-")}</td>
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

<#include "footer.ftl">
</body>
</html>
