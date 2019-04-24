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
                <div class="col-1">
                </div>
                <div class="col-10 my-auto text-center ">
                    <form class="form-inline "  >
                        <input class="form-control mr-sm-2" style="width: 80%; " type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn btn btn-outline-primary my-2 my-sm-0"   type="submit">Search</button>
                        <div class="dropdown">
                            <button class="btn btn btn-outline-primary dropdown-toggle"  type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Категории
                            </button>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                <a class="dropdown-item "  href="<@spring.url "/"/>books/all">Воспитание</a>
                                <a class="dropdown-item" href="<@spring.url "/"/>books/all">Образование</a>
                                <a class="dropdown-item" href="<@spring.url "/"/>books/all">Дом.Быт</a>
                                <a class="dropdown-item" href="<@spring.url "/"/>books/all">Наука</a>
                                <a class="dropdown-item" href="<@spring.url "/"/>books/all">Детская литература</a>
                                <a class="dropdown-item" href="<@spring.url "/"/>books/all">Медицина</a>
                                <a class="dropdown-item" href="<@spring.url "/"/>books/all">Право</a>
                                <a class="dropdown-item" href="<@spring.url "/"/>books/all">Прикладные науки</a>
                                <a class="dropdown-item" href="<@spring.url "/"/>books/all">Филология</a>
                                <a class="dropdown-item" href="<@spring.url "/"/>books/all">Художетсвенная литература</a>
                            </div>
                        </div>
                    </form>

                </div>
                <div class="col-1">
                </div>
            </div>
            <div class="row">
                <#list model.books as book>

                    <div class="col-6 col-sm-4 col-md-3 col-xs-2 my-auto text-center" STYLE="overflow: hidden;padding-left: 2%; padding-top: 1%;padding-bottom: 1%;">
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
