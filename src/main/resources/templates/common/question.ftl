<#ftl encoding='UTF-8'>
<!DOCTYPE html>
    <html>
    <#include "../head.ftl">
    <body>
    <#include "../header.ftl">
    <div class="container-fluid" style="padding-top: 10px; padding-bottom: 10px;">
        <h2 style="text-align: center;">Задайте вопрос!</h2>
        <div class="row">
            <div class="col-1 col-sm-1 col-md-2 col-lg-3"></div>
            <div class="col-10 col-sm-10 col-md-8 col-lg-6">
                <form action="question" method='POST'>
                    <div class="form-group">
                        <#if success??>
                            <div class="alert alert-success" role="alert">${success}</div>
                        </#if>
                    </div>
                    <#--Чтобы не было соблазно второй раз отправить-->
                    <#if !success??>
                    <div class="form-group">
                        <label for="inputLogin">Введите ваш вопрос!</label>
                        <textarea name="text" rows="10" class="form-control"></textarea>
                    </div>

                    <div class="form-group">
                        <input class="form-control" type="submit" value="Отправить!">
                    </div>
                    </#if>
                </form>
            </div>
            <div class="col-1 col-sm-1 col-md-2 col-lg-3"></div>
        </div>
    </div>
<#include "../footer.ftl">
    </body>
    </html>