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
                <h2>Создание книги</h2>
            </div>
            <div class="form-group" style="padding-top: 10px">
                <a href="all">
                    <button class="btn btn-secondary">Назад</button>
                </a>
            </div>
            <form action="" method='POST' enctype="multipart/form-data">
                <div class="form-group">
                    <#if errors??>
                        <#list errors as error>
                            <div class="alert alert-danger" role="alert">${error}</div>
                        </#list>
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
                    <label>Введите название</label>
                    <input name="name" class="form-control" placeholder="Название"
                           value="${model.book???then(model.book.name, "")}"/>
                </div>

                <div class="form-group">
                    <label>Введите автора</label>
                    <input name="author" class="form-control" placeholder="Автор"
                           value="${model.book???then(model.book.author, "")}"/>
                </div>

                <div class="form-group">
                    <label>Введите количество страниц</label>
                    <input name="pageCount" type="number" min="0" class="form-control" placeholder="100"
                           value="${model.book???then(model.book.pageCount, "")}"/>
                </div>

                <div class="form-group">
                    <label>Выберите обложку</label>
                    <input name="titlePage" id="titlePage" accept="image/*"
                           type="file"
                           class="form-control"
                    />
                    <#--<script type="text/javascript">-->
                        <#--document.addEventListener("DOMContentLoaded", function(event) {-->
                            <#--$("#titlePage").files. = "<@spring.url "/"/>file/${model.book.titlePageId?c}";-->
                        <#--});-->
                    <#--</script>-->
                </div>

                <div class="form-group">
                    <label>Выберите категорию</label>
                    <select name="categoryId" class="form-control">
                        <#list model.categories as category>
                            <option value="${category.id}"<#if (model.book?? && category.name == model.book.categoryName)>
                                selected="selected"</#if>>${category.name}</option>
                        </#list>
                    </select>
                </div>

                <div class="form-group">
                    <label>Выберите издателя</label>
                    <select name="publisherId" class="form-control">
                        <#list model.publishers as publisher>
                            <option value="${publisher.id}"<#if (model.book?? && publisher.name == model.book.publisherName)>
                                selected="selected"</#if>>${publisher.name}</option>
                        </#list>
                    </select>
                </div>

                <div class="form-group">
                    <label>Описание</label>
                    <textarea name="description" maxlength="1024" class="form-control"
                              placeholder="Описание">${model.book???then(model.book.description, "")}</textarea>
                </div>

                <div class="form-group">
                    <label>Цена</label>
                    <input name="price" type="number" min="1" class="form-control"
                           placeholder="Цена" value="${model.book???then(model.book.price?c, "")}">
                </div>

                <div class="form-group">
                    <label>Количество</label>
                    <input name="count" type="number" min="1" class="form-control"
                           placeholder="Количество" value="${model.book???then(model.book.count?c, "")}">
                </div>

                <div class="form-group">
                    <label>Рейтинг</label>
                    <input name="rating" type="number" min="1" class="form-control"
                           placeholder="Рейтинг" value="${model.book???then(model.book.rating?c, "")}">
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
