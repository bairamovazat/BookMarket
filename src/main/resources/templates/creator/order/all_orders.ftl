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
                    <th scope="col">#</th>
                    <th scope="col">Адрес</th>
                    <th scope="col">Статус</th>
                    <th scope="col">Оплата</th>
                    <th scope="col">Дата создания</th>
                    <th scope="col">Цена</th>
                    <th scope="col">Установть</th>
                </tr>
                </thead>
                <tbody>
                <#list model.orders as order>
                <tr>
                    <th scope="row"><a>${order.id!}</a></th>
                    <td>${order.address!}</td>
                    <td>${order.status!}</td>
                    <td>${order.payAfterDelivery???string("После доставки", "До доставки")}</td>
                    <td>${order.createDate!}</td>
                    <td>${order.price!}Руб</td>
                    <td>
                        <div class="dropdown">
                            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton"
                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                ${order.status!}
                            </button>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                <a class="dropdown-item" href="change?status=CREATE&id=${order.id!}&redirectPage=${model.currentPage}">CREATE</a>
                                <a class="dropdown-item" href="change?status=EXPECT_PAYMENT&id=${order.id!}&redirectPage=${model.currentPage}">EXPECT_PAYMENT</a>
                                <a class="dropdown-item" href="change?status=PROCESSED&id=${order.id!}&redirectPage=${model.currentPage}">PROCESSED</a>
                                <a class="dropdown-item" href="change?status=SHIPPED&id=${order.id!}&redirectPage=${model.currentPage}">SHIPPED</a>
                                <a class="dropdown-item" href="change?status=DELIVERED&id=${order.id!}&redirectPage=${model.currentPage}">DELIVERED</a>
                            </div>
                        </div>
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
