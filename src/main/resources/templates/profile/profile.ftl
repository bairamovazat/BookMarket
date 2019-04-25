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

    figcaption.ratings a {
        color: #f1c40f;
        font-size: 11px;
    }

    figcaption.ratings a:hover {
        color: #f39c12;
        text-decoration: none;
    }

    .emphasis h2 {
        margin-bottom: 0;
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

                                <button type="button" class="btn btn-primary"
                                        data-toggle="modal" data-target="#changePassword">
                                    Изменить пароль
                                </button>

                                <button type="button" class="btn btn-primary"
                                        data-toggle="modal" data-target="#changeEmail">
                                    Изменить почту
                                </button>
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
    <div class="modals">
        <!-- Modal -->
        <div class="modal fade" id="changePassword" tabindex="-1"
             role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <form class="form-group" action="profile/change/password" method="post">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLongTitle">Изменить пароль</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">

                            <div class="form-group">
                                <label>Введите текущий пароль</label>
                                <input name="currentPassword" type="password" class="form-control">
                            </div>

                            <div class="form-group">
                                <label>Введите новый пароль</label>
                                <input name="password" type="password" class="form-control">
                            </div>

                            <div class="form-group">
                                <label>Введите повтор нового пароля</label>
                                <input name="passwordRepeat" type="password" class="form-control">
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Закрыть</button>
                            <button type="submit" class="btn btn-primary">Изменить</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <!-- Modal -->
        <div class="modal fade" id="changeEmail" tabindex="-1"
             role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <form class="form-group" action="profile/change/email" method="post">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLongTitle">Изменить пароль</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">

                            <div class="form-group">
                                <label>Введите новую почту</label>
                                <input name="newEmail" type="text" class="form-control">
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Закрыть</button>
                            <button type="submit" class="btn btn-primary">Изменить</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</div>

<#include "../footer.ftl">
</body>
</html>