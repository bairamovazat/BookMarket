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
                <h2>Книги <a href="create"><button class="btn btn-sm btn-primary">+</button></a></h2>
            </div>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">Обложка</th>
                    <th scope="col">Название</th>
                    <th scope="col">Автор</th>
                    <th scope="col">Категория</th>
                    <th scope="col">Издательство</th>
                    <th scope="col">Цена</th>
                </tr>
                </thead>
                <tbody>
                <#list model.books as book>
                <tr>
                    <td style="padding: 0px">
                        <img src="<@spring.url "/file/"/>${book.titlePageId?html}"
                             style="max-height: 50px; max-width: 50px;">
                    </td>
                    <td>${book.name!}</td>
                    <td>${book.author!}</td>
                    <td>${book.categoryName!}</td>
                    <td>${book.publisherName!}</td>
                    <td>${book.price!}</td>
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
