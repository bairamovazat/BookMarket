function updateBasketPageElement() {
    var basketContent = document.getElementById("basketContent");
    var i = 0;
    var basket = getBasket();
    basket.forEach(function (value) {
        basketContent.appendChild(createBasketDomElement(value.id, value.name, value.count, value.price, i++))
    });
    updateSum();
    if(basket.length === 0){
        document.getElementById("submit-order").disabled  = true;
    }else {
        document.getElementById("submit-order").disabled  = false;
    }
}

function updateSum() {
    var summ = 0;
    getBasket().forEach(function (value) {
        summ += value.count * value.price;
    });
    document.getElementById("totalPrice").innerText = "Итого: " + summ;
}

function changeCountFunction(event, id) {
    var basket = getBasket();
    var basketElement = basket.find(function (value) {
        return value.id === id;
    });
    basketElement.count = +event.target.valueAsNumber;
    putBasket(basket);
    if(basketElement.count === 0){
        basket.splice(basket.indexOf(basketElement), 1);
        event.target.parentElement.parentElement.parentElement.removeChild(event.target.parentElement.parentElement);
        putBasket(basket);
    }
    console.log(basket);
    updateSum();
}

function createBasketDomElement(id, name, count, price, formId) {
    var tr = document.createElement("tr");
    var nameTd = document.createElement("td");
    nameTd.innerText = name;

    var countTd = document.createElement("td");
    // countTd.innerText = count;

    var priceTd = document.createElement("td");
    priceTd.innerText = "" + price;

    var idInput = document.createElement("input");
    idInput.type = "text";
    idInput.style.display = "none";
    idInput.name = "books[" + formId + "].id";
    idInput.value = id;

    var changeCount = document.createElement("input");
    changeCount.style.width = "100px";
    changeCount.className = "form-control";
    changeCount.type = "number";
    changeCount.min = "0";
    changeCount.value = count;
    changeCount.name = "books[" + formId + "].count";

    changeCount.onclick = function (event) {
        changeCountFunction(event, id);
    };
    countTd.appendChild(changeCount);

    tr.appendChild(nameTd);
    tr.appendChild(idInput);
    tr.appendChild(countTd);
    tr.appendChild(priceTd);
    return tr;
}

document.addEventListener("DOMContentLoaded", updateBasketPageElement);