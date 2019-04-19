<#ftl encoding='UTF-8'>
<!DOCTYPE html>
<html>
<#include "../head.ftl">
<body>
<#include "../header.ftl">
<style type="text/css">
    .profile {
        min-height: 355px;
        display: inline-block;
    }

    figcaption.ratings {
        margin-top: 20px;
    }

    figcaption.ratings a {
        color: #f1c40f;
        font-size: 11px;
    }

    figcaption.ratings a:hover {
        color: #f39c12;
        text-decoration: none;
    }

    .divider {
        border-top: 1px solid rgba(0, 0, 0, 0.1);
    }

    .emphasis {
        border-top: 4px solid transparent;
    }

    .emphasis:hover {
        border-top: 4px solid #1abc9c;
    }

    .emphasis h2 {
        margin-bottom: 0;
    }

    span.tags {
        background: #1abc9c;
        border-radius: 2px;
        color: #f5f5f5;
        font-weight: bold;
        padding: 2px 4px;
    }

    .dropdown-menu {
        background-color: #34495e;
        box-shadow: none;
        -webkit-box-shadow: none;
        width: 250px;
        margin-left: -125px;
        left: 50%;
    }

    .dropdown-menu .divider {
        background: none;
    }

    .dropdown-menu > li > a {
        color: #f5f5f5;
    }

    .dropup .dropdown-menu {
        margin-bottom: 10px;
    }

    .dropup .dropdown-menu:before {
        content: "";
        border-top: 10px solid #34495e;
        border-right: 10px solid transparent;
        border-left: 10px solid transparent;
        position: absolute;
        bottom: -10px;
        left: 50%;
        margin-left: -10px;
        z-index: 10;
    }
</style>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-1 col-lg-2 col-xs-3">

        </div>
        <div class="col-12 col-sm-12 col-md-10 col-lg-8 col-xs-6">
            <div class="card">
                <div class="card-body">
                    <div class="well profile col-12">
                        <div class="col-sm-12 d-flex">
                            <div class="col-xs-12 col-sm-8">
                                <h2>${model.user.get().name}</h2>
                                <p><strong>Логин: </strong> ${model.user.get().login} </p>
                                <p><strong>Почта: </strong>${model.user.get().email}</p>
                                <p><strong>Статус: </strong>${model.user.get().state}</p>
                                <p><strong>Заказы: </strong><a href="order/all">Просмотреть</a></p>

                                <#if model.user.get().hasRole("CREATOR")>
                                    <p>
                                        <strong>Панель модератора: </strong>
                                        <a href="creator">панель</a>
                                    </p>
                                </#if>
                                 <#if model.user.get().hasRole("ADMIN")>
                                    <p>
                                        <strong>Панель администратора: </strong>
                                        <a href="admin">панель</a>
                                    </p>
                                 </#if>
                            </div>
                            <div class="col-xs-12 col-sm-4 text-center" style="padding-top: 25px;">
                                <figure>
                                    <img style="width: 100px; height: 100px;" src="resources/user.png" alt=""
                                         class="img-circle img-responsive">
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-md-1 col-lg-2 col-xs-3">

    </div>
</div>
</div>

<#include "../footer.ftl">
</body>
</html>