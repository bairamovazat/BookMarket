<#ftl encoding='UTF-8'>
<!DOCTYPE html>
<html>
<#include "../head.ftl">
<body>
<#include "../header.ftl">
<div class="container-fluid" style="padding-top: 10px; padding-bottom: 10px;">
    <div class="row">
        <div class="col-md-1 mx-auto"></div>
        <div class="col-md-10 mx-auto">
            <h2>${model.book.name}</h2><br>
            <div class="row">
                <div class="col-md-3 col-sm-4 col-6 mx-auto">
                    <p><img src="<@spring.url "/file/"/>${model.book.titlePageId???then(model.book.titlePageId?c, "")}"
                            width="100%" height="auto"/></p>
                    <p><input type="button" class="btn btn-primary" value="В корзину"
                              onclick='putElementInBasket(${model.book.id!}, "${model.book.name!}", ${model.book.price?c})'/>
                    </p>
                </div>
                <div class="col-md-4 col-sm-8 col-6 mx-auto">
                    <p>Цена : <label id="price">${model.book.price!}</label><br>
                        ФИО автора : <label id="author">${model.book.author!}</label><br>
                    <#--Год публикации : <label id="year">2017</label><br>-->
                        Издательство : <label id="publisher">${model.book.publisherName!}</label><br>
                        Раздел каталог : <label id="category">${model.book.categoryName!}</label><br>
                    <#--Серия книги : <label id="seria">Высшее медицинское образование</label><br>-->
                    <#--ISBN : <label id="isbn">9785222274316</label><br>-->
                    <#--Артикул : <label id="articul">O0078905</label><br>-->
                        Количество страниц : <label id="pagenum">${model.book.pageCount!}</label><br>
                    <#--Тип переплета : <label id="pereplet">матовая</label><br>-->
                    <#--Полиграфический формат издания : <label id="format">84*108/32</label><br>-->
                    <#--Вес книги : <label id="weight">262 г</label><br>-->
                        Книг в наличии : <label id="instock">${model.book.count!}</label></p>
                </div>
                <div class="col-md-5 col-sm-12 col-12 mx-auto">
                    <p><h5>Рейтинг: <label id="raiting">${model.book.rating!}</label></h5></p>
                    <p><h5>Аннотация:<br></h5>
                    <label id="annotation">${model.book.description!}</label></p>
                </div>
            </div>
        </div>
        <div class="col-md-1 mx-auto"></div>
    </div>
    <#if model.user.isPresent()>
    <div class="row">
        <div class="col-1 mx-auto"></div>
        <div class="col-10 mx-auto">
            <form action="../comment/${model.book.id}" method="post">
                <div class="form-group">
                    <#if error??>
                        <div class="alert alert-danger" role="alert">${error}</div>
                    </#if>
                    <p><h5>Добавить комментарий:<br></h5></p>
                    <textarea name="text" class="form-control" id="comment"
                              placeholder="Напишите комментарий к книге..."
                              maxlength="2048" rows="5" style="width: 100%"></textarea>
                    <br><input type="submit" class="btn btn-primary form-control" value="Отправить"
                               style="float: right;"/>
                </div>
            </form>
        </div>
        <div class="col-1 mx-auto"></div>
    </div>
    </#if>
    <hr>
    <div class="row">
        <div class="col-1 mx-auto"></div>
        <div class="col-10 mx-auto">
            <p><h5>Комментарии:<br></h5></p>
                <#list model.book.comments as comment>
                <div>
                    <p><b>${comment.userName!}</b><br>
                        ${comment.text!}<br>
                        ${comment.createdDate!}</p>
                </div>
                </#list>
        </div>
        <div class="col-1 mx-auto"></div>
    </div>
</div>

<#include "../footer.ftl">
</body>
</html>