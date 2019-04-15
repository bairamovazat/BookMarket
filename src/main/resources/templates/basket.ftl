<#ftl encoding='UTF-8'>
<!DOCTYPE html>
<html>
     <#include "head.ftl">
<body>
<#include "header.ftl">
<script src="<@spring.url "/"/>js/basket_page.js"></script>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-1 col-lg-2 col-xs-3">

        </div>
        <div class="col-12 col-sm-12 col-md-10 col-lg-8 col-xs-6">
            <div style="text-align: center">
                <h2>Корзина</h2>
            </div>
            <form method="post" action="">
                <div class="form-group">
                    <#if error??>
                        <div class="alert alert-danger" role="alert">${error}</div>
                    </#if>
                </div>
                <div class="form-group">
                    <#if success??>
                        <script>
                            putBasket([]);
                            document.addEventListener("DOMContentLoaded", function () {
                                updateBasketPageElement();
                                updateBasketElement();
                            });
                        </script>
                        <div class="alert alert-success" role="alert">${success}</div>
                    </#if>
                </div>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th scope="col">Название</th>
                        <th scope="col">Количество</th>
                        <th scope="col">Цена</th>
                    </tr>
                    </thead>
                    <tbody id="basketContent">
                    </tbody>
                </table>

                <div class="form-group">
                    <label>Оплата после получения?
                        <input type="checkbox" name="payAfterDelivery"/>
                    </label>
                </div>
                <div class="form-group">
                    <label>Введите адрес доставки</label>
                    <input maxlength="254" name="address" class="form-control" placeholder="г.Казань. Авангардная 123"/>
                </div>
                <div class="form-group">
                    <label>Введите комментарий</label>
                    <input maxlength="512" name="comment" class="form-control" placeholder="Комментарий"/>
                </div>
                <div style="text-align: right; display: flex; flex-direction: row; justify-content: flex-end">
                    <h4 id="totalPrice" style="padding-top: 4px; padding-right: 4px;">
                        Итого: 0
                    </h4>
                    <button id="submit-order" class="btn bth-primary">
                        Оформить
                    </button>
                </div>
            </form>
        </div>
        <div class="col-md-1 col-lg-2 col-xs-3">

        </div>
    </div>
</div>
<style type="text/css">

</style>
<#include "footer.ftl">
</body>
</html>