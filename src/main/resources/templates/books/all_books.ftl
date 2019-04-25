<#ftl encoding='UTF-8'>
<!DOCTYPE html>
<html>
     <#include "../head.ftl">
<body>
<#include "../header.ftl">
<div class="container-fluid h-100">
    <div class="row">
        <div class="col-12">
            <div class="row" style=" padding-top: 2%;">
                <script src="<@spring.url "/"/>js/book_form.js"></script>
                <div class="col-1">
                </div>
                <div class="col-10 my-auto text-center" style="position: relative;">
                    <form class="form-inline" style="width: 100%; position: relative;" method="get">
                        <input class="form-control" type="search" name="query" value="${RequestParameters.query!}"
                               placeholder="Search" aria-label="Search" style="width: calc(100% - 74px);">
                        <button class="btn btn btn btn-outline-primary my-2 my-sm-0" type="submit">Search</button>

                        <div class="dropdown">
                            <button class="btn btn btn-outline-primary dropdown-toggle" type="button"
                                    id="categoryDropdownMenuButton" data-toggle="dropdown" aria-haspopup="true"
                                    aria-expanded="false">
                                Категория
                            </button>
                            <input style="display:none;" name="categoryId" id="category">
                            <div class="dropdown-menu" aria-labelledby="categoryDropdownMenuButton">
                                <a class="dropdown-item" href="#"
                                   onclick="setCategory('', 'Категория')">Категория</a>
                                <#list model.categories as category>
                                    <a class="dropdown-item" href="#"
                                       onclick="setCategory('${category.id}', '${category.name}')">${category.name}</a>
                                    <#if RequestParameters.categoryId?? && RequestParameters.categoryId! == category.id?c>
                                        <script type="text/javascript">
                                            document.addEventListener("DOMContentLoaded", function () {
                                                setCategory('${category.id}', '${category.name}');
                                            });
                                        </script>
                                    </#if>
                                </#list>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="col-1">

                </div>
            </div>
            <div class="row">
                <#list model.books as book>

                    <div class="col-6 col-sm-4 col-md-3 col-xs-2 my-auto text-center"
                         style="overflow: hidden;padding-left: 2%; padding-top: 1%;padding-bottom: 1%;">
                        <div class="card" style="padding-left: 2%">
                            <div class="center-block" style="width: 100%;height: auto">
                                <a href="show/${book.id?c}">
                                    <img class="card-img-top"
                                         style="max-height: 300px;max-width: 200px;"
                                         src="<@spring.url "/file/"/>${book.titlePageId???then(book.titlePageId?c, "")}">
                                </a>
                            </div>
                            <div class="card-body">
                                ${book.price!} ₽
                                <a class="btn btn-primary" style="color: white" role="button"
                                   onclick='putElementInBasket(${book.id!}, "${book.name!}", ${book.price?c})'>
                                    Купить
                                </a>
                            </div>
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item">
                                    <div style="vertical-align: baseline;">${book.name!}</div>
                                </li>
                                <li class="list-group-item">
                                    <div class="font-weight-light"
                                         style="font-size: 14px;vertical-align: baseline;">${book.author!}</div>
                                </li>
                                <li class="list-group-item">
                                    <div class="font-weight-light" style="font-size: 12px;">${book.publisherName!}</div>
                                </li>
                            </ul>

                        </div>
                    </div>
                </#list>
            </div>
            <nav aria-label="navigation">
                <ul class="pagination justify-content-center">
                    <li class="page-item ${((model.currentPage == 0)?string("disabled",""))}">
                        <a class="page-link"
                           href="?page=${model.currentPage - 1}&query=${RequestParameters.query!}&categoryId=${RequestParameters.categoryId!}"
                           tabindex="-1">Previous</a>
                    </li>
                    <#list model.pageList as page>
                        <li class="page-item ${((page == model.currentPage)?string("active",""))}">
                            <a class="page-link"
                               href="?page=${page}&query=${RequestParameters.query!}&categoryId=${RequestParameters.categoryId!}">
                                ${page}
                            </a>
                        </li>
                    </#list>

                    <li class="page-item
                        ${((model.pageList?size <= 0 || model.currentPage == model.pageList[model.pageList?size - 1])?string("disabled",""))}
                        ">
                        <a class="page-link"
                           href="?page=${model.currentPage + 1}&query=${RequestParameters.query!}&categoryId=${RequestParameters.categoryId!}">Next</a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</div>
<#include "../footer.ftl">
</body>
</html>
