<#ftl encoding='UTF-8'>
<!DOCTYPE html>
<html>
<#include "../head.ftl">
<body>
<#include "../header.ftl">
<div class="container-fluid" >
    <div class="col-12">
    <div class="row">
            <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img class="d-block w-100" src="<@spring.url "/"/>resources/image/slide1.jpg" alt="Первый слайд">
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100" src="<@spring.url "/"/>resources/image/slide2.jpg" alt="Второй слайд">
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100" src="<@spring.url "/"/>resources/image/slide3.jpg" alt="Третий слайд">
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
    </div>

        <h1 class="text-center p-3">Выбор редакции</h1>
        <div class="row">
               <#list model.editorChoseBooks as book>
                    <div class="col-6 col-sm-4 col-md-3 col-xs-2 my-auto text-center" style="overflow: hidden;padding-left: 2%">
                        <div class="card" style="padding-left: 2%">
                            <div class="center-block" style="width: 100%;height: auto">
                                <a href="books/show/${book.id?c}">
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
        <h1 class="text-center p-3">Распродажа</h1>
        <div class="row">
               <#list model.saleBooks as book>
                   <div class="col-6 col-sm-4 col-md-3 col-xs-2 my-auto text-center" style="overflow: hidden;padding-left: 2%">
                       <div class="card" style="padding-left: 2%">
                           <div class="center-block" style="width: 100%;height: auto">
                               <a href="books/show/${book.id?c}">
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
        <h1 class="text-center p-3">Книга дня</h1>
        <div class="row">
               <#list model.dayBooks as book>
                   <div class="col-6 col-sm-4 col-md-3 col-xs-2 my-auto text-center" style="overflow: hidden;padding-left: 2%">
                       <div class="card" style="padding-left: 2%">
                           <div class="center-block" style="width: 100%;height: auto">
                               <a href="books/show/${book.id?c}">
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
        <h1 class="text-center p-3">Художественная литература</h1>
        <div class="row">
               <#list model.fictionBooks as book>
                   <div class="col-6 col-sm-4 col-md-3 col-xs-2 my-auto text-center" style="overflow: hidden;padding-left: 2%">
                       <div class="card" style="padding-left: 2%">
                           <div class="center-block" style="width: 100%;height: auto">
                               <a href="books/show/${book.id?c}">
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
        <h1 class="text-center p-3">Отзывы</h1>
        <div class="row">
            <div class="col-12 col-sm-8 col-md-6 col-xs-4 my-auto text-center" style="overflow: hidden;padding-left: 2%">
                <div class="card" style="padding-left: 2%">
                    <div class="card-body">
                        <p>Царева Наталья</p>
                        Новые "Двенадцать месяцев" - книга-театр, особый проект этого года. Она, конечно,
                        не отменяет ожидаемую всеми новинку в одной из двух больших исторических серий ("Книга+эпоха" и "Хронограф").
                        Просто в этом gгоду мы хорошо себя вели и очень старались, поэтому под новогодней елкой будет не одна большая
                        интерактивная книга от "Лабиринта".

                    </div>
                </div>
            </div>
            <div class="col-12 col-sm-8 col-md-6 col-xs-4 my-auto text-center" style="overflow: hidden;padding-left: 2%">
                <div class="card" style="padding-left: 2%">
                    <div class="card-body">
                        <p>Царева Наталья</p>
                        Новые "Двенадцать месяцев" - книга-театр, особый проект этого года. Она, конечно,
                        не отменяет ожидаемую всеми новинку в одной из двух больших исторических серий ("Книга+эпоха" и "Хронограф").
                        Просто в этом году мы хорошо себя вели и очень старались, поэтому под новогодней елкой будет не одна большая
                        интерактивная книга от "Лабиринта".
                    </div>
                </div>
            </div>
            </div>
        </div>
    </div>
<#include "../footer.ftl">
</body>
</html>