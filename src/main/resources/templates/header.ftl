<#import "spring.ftl" as spring />
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <a class="navbar-brand" href="#">Navbar</a>

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsingNavbarLg">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="navbar-collapse collapse" id="collapsingNavbarLg">
        <ul class="navbar-nav">
            <#if model.user.isPresent()>
                <li class="nav-item">
                    <a class="nav-link" href="<@spring.url "/"/>books/all">Книги
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<@spring.url "/"/>profile">Личный кабинет
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<@spring.url "/"/>logout">Выход</a>
                </li>
            </#if>
             <#if !model.user.isPresent()>
                <li class="nav-item">
                    <a class="nav-link" href="<@spring.url "/"/>login">Авторизация</a>
                </li>
             </#if>
        </ul>

        <ul class="nav navbar-nav navbar-right">
            <li class="nav-item">
                <a onclick="updateBasketElement(event)" class="nav-link" id="basket">Корзина</a>
            </li>
        </ul>
    </div>
</nav>