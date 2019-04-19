function basketElement(id, name, price) {
    var obj = {};
    obj.id = id;
    obj.name = name;
    obj.count = 1;
    obj.price = +price;
    return obj;
}

function updateBasketElement() {
    document.getElementById("basket").innerText = (getBasket().length);
}

function getBasket() {
    var basket = localStorage.getItem("basket");
    if (basket == null) {
        putBasket([]);
    }
    return JSON.parse(localStorage.getItem("basket"));
}

function putBasket(basket) {
    localStorage.setItem("basket", JSON.stringify(basket));
}

function putElementInBasket(id, name, price) {
    var basket = getBasket();
    var elementInStorage = basket.find(function (elem) {
        return elem.id === id;
    });

    var element;
    if (elementInStorage != null) {
        element = elementInStorage;
        element.name = name;
        element.price = price;
        element.count += 1;
    } else {
        element = basketElement(id, name, price);
        basket.push(element)
    }
    putBasket(basket);
    updateBasketElement();
}

document.addEventListener("DOMContentLoaded", updateBasketElement);
