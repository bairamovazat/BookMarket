<#ftl encoding='UTF-8'>
<!DOCTYPE html>
<html>
     <#include "../head.ftl">
<body>
<#include "../header.ftl">
<div class="container-fluid h-100">

    <div class="row">

        <div class="col-12">
            <div class="row">
                <#list model.books as book>

                    <div class="col-6 col-sm-4 col-md-3 col-xs-2 my-auto text-center" STYLE="overflow: hidden;padding-left: 2%">
                        <div class="card" STYLE="padding-left: 2%">
                            <div class="center-block" style="width: 100%;height: auto">
                                <a href="show/${book.id?c}">
                                <img class="card-img-top"
                                     style="max-height: 300px;max-width: 200px;"
                                     src="<@spring.url "/file/"/>${book.titlePageId???then(book.titlePageId?c, "")}">
                                </a>
                            </div>
                            <div class="card-body">
                                ${book.price!} ₽
                                <a class="btn btn-primary" role="button" href="#"
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
    </div>
</div>

<#include "../footer.ftl">
</body>
</html>
