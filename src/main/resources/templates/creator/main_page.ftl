<#ftl encoding='UTF-8'>
<!DOCTYPE html>
<html>
     <#include "../head.ftl">
<body>
<#include "../header.ftl">
<div class="container-fluid">
    <div class="row">
        <div class="col-md-1 col-lg-2 col-xs-3">

        </div>
        <div class="col-12 col-sm-12 col-md-10 col-lg-8 col-xs-6">
            <h2 class="text-center">Панель модератора</h2>
            <div class="row">
                <div class="form-group col-4">
                    <a class="form-control" href="creator/orders/all">Заказы</a>
                </div>
                <div class="form-group col-4">
                    <a class="form-control" href="creator/books/all">Книги</a>
                </div>
                <div class="form-group col-4">
                    <a class="form-control" href="creator/categories/all">Категории</a>
                </div>
                <div class="form-group col-4">
                    <a class="form-control" href="creator/publishers/all">Издательства</a>
                </div>
            </div>
            <div class="row" style="padding-left: 15px">
                <form class="form-group" action="import/from" method="GET">
                    <label>Введите путь до папки на компьютере для импорта файлов</label>
                    <input class="form-control" name="path"/>
                    <input class="btn" type="submit" value="Отправить"/>
                </form>
            </div>
        </div>

        <div class="col-md-1 col-lg-2 col-xs-3">

        </div>
    </div>
</div>

<#include "../footer.ftl">
</body>
</html>
