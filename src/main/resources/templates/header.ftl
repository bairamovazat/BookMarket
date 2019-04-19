<#import "spring.ftl" as spring />
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <a class="navbar-brand" href="#"><svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="128" height="80" viewBox="0 0 128 80">
            <metadata><?xpacket begin="﻿" id="W5M0MpCehiHzreSzNTczkc9d"?>
                <x:xmpmeta xmlns:x="adobe:ns:meta/" x:xmptk="Adobe XMP Core 5.6-c142 79.160924, 2017/07/13-01:06:39        ">
                    <rdf:RDF xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#">
                        <rdf:Description rdf:about=""/>
                    </rdf:RDF>
                </x:xmpmeta><?xpacket end="w"?></metadata>
            <image id="Слой_1" data-name="Слой 1" x="5" width="118" height="80" xlink:href="data:img/png;base64,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"/>
        </svg>
    </a>
    <h4 class="text-white text-center">Тот<br>книжный магазин</h4>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsingNavbarLg">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="navbar-collapse collapse" id="collapsingNavbarLg">
                <form class="form-inline" style="width: 45%;padding-left: 1%;">
                    <input class="form-control mr-sm-2" style="width: 80%; " type="search" placeholder="Search" aria-label="Search">

                    <button class="btn btn-outline-light my-2 my-sm-0" type="submit">Search</button>
                </form>
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="#">
                    <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="50" height="50" viewBox="0 0 50 50">
                        <metadata><?xpacket begin="﻿" id="W5M0MpCehiHzreSzNTczkc9d"?>
                            <x:xmpmeta xmlns:x="adobe:ns:meta/" x:xmptk="Adobe XMP Core 5.6-c142 79.160924, 2017/07/13-01:06:39        ">
                                <rdf:RDF xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#">
                                    <rdf:Description rdf:about=""/>
                                </rdf:RDF>
                            </x:xmpmeta><?xpacket end="w"?></metadata>
                        <image id="Слой_1" data-name="Слой 1" x="4" y="8" width="32" height="40" xlink:href="data:img/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAwCAMAAABHcohdAAAABGdBTUEAALGPC/xhBQAAACBjSFJNAAB6JgAAgIQAAPoAAACA6AAAdTAAAOpgAAA6mAAAF3CculE8AAABmFBMVEUAAAAqKiq8vLnq6ure3t7u7u729vbs7Oy7u7szMzOJiYnh4eH39/fj4+OEhITQ0ND7+/vOzs6IiIju7u7+/v7u7u6EhIS6urrx8fHx8fGzs7ORkZGNjY0AAADw8PAAAADS0tLR0dH5+fn5+fl/f3/j4eHg4OD39/f+/v729va5ubn4+Pjg4OCCgoJ/f3/j4+O3t7fv7++urq6xsbHu7u7f39+lpaWsrKzf39/u7u7d3d3d3d36+vp/f398fHz7+/vy8vLx8fHk5OTi4uLf39/b29vd3d3g4OD19fW7u7u9vb319fW1tbWkpKRMTEz8/Pz6+vrd3d0AAADi4uLe3t7m5uTh4eF5eXlpaWni4uLh4eHT09PCwsLz8/Pv7+/c3NzZ2dn4+Pg/Pz/e3t7Z2dlycnLy8vLY2NjV1dVFRUXu7u7Pz8/ExMTp6enn5+fU1NTPz88/Pz/v7+/u7u68vLz8/Pyfn5/KysrIyMjs7Ozq6urw8PBbW1vR0dH8/PzS0tLHx8fHx8fq6urk5OTq6urq6ur///8AAACtXXXtAAAAhnRSTlMABkl+utrmfUgFGoLlgRlz7HMcu/e6GyXU0yUcGwO8AnNx6ukYgX/m7+VJ5ncnKHdHyyMke7kiIrjceXrpJifr4N/KxqJ6e5VuJidqRT4K7uqAAb2saF8XEbSqUkjg1nVl5wh+bRTecV0LylBBtaZ3ZQTDtir1IGtZqZXQDjj2M2lhnpGxsAEKOf0AAAABYktHRACIBR1IAAAACXBIWXMAAAc6AAAHOgGqxcQdAAAAB3RJTUUH4wQTDysV+9nDggAAAaVJREFUOMt9lPVbwzAQhg8ZY8gYrDhlwJDCYDBch7sNdxnu7q75u+nYmqsk/X5K7nuf9HKXHgBVVHRMrCUuzhJrjbeBUQmJSYQqKdmu91McRCNHqsZOcwpEJyE9A/3MLMJQdo7i5zJ9mcgL+2I+4cjp+gcKCFeFId9exAfcxTJQQkxUKtevTBORJM223AYVqq2nskoUvdUeVagGrLjx1YavVefDWD00YEaNSmGa3DTYDC103YqlbaNBC7TTdQcCfjwWaBclFwIuepdO6DIHuqGHnuZHwEuDvdBH1/0IDNDgIAxhPsOKP4LXHIUx80KNw8Qk7gJTVdPT3qkARjrl9z1j1qxZ+cA5s3bPy8CCxPcnF0M5LfGB5f+kV7i+sBp+1Ws8YD1Slw0esBkBFoNsf21LKe02G9ihvdn1sPy9CezePgs4UP3+h3tG/0j1gACOjfPhRDthTvXAmW4E1elGUDBXP6TOtR+4MEy5yys1cM2Ygze36LvvGADc05sID8DUowI8sX3YjUy75xcOAK9vIf/2Hbj6kNMQPsFEX4R8m/lg+/kVtZE/x2/edasU+vwAAAAASUVORK5CYII="/>
                    </svg>
                    <br>Город
                </a>
            </li>
            <#if model.user.isPresent()>

                <li class="nav-item">
                    <a class="nav-link" href="<@spring.url "/"/>profile">
                        <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="50" height="50" viewBox="0 0 50 50">
                            <metadata><?xpacket begin="﻿" id="W5M0MpCehiHzreSzNTczkc9d"?>
                                <x:xmpmeta xmlns:x="adobe:ns:meta/" x:xmptk="Adobe XMP Core 5.6-c142 79.160924, 2017/07/13-01:06:39        ">
                                    <rdf:RDF xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#">
                                        <rdf:Description rdf:about=""/>
                                    </rdf:RDF>
                                </x:xmpmeta><?xpacket end="w"?></metadata>
                            <image id="Слой_1" data-name="Слой 1" x="5" y="8" width="42" height="43" xlink:href="data:img/png;base64,iVBORw0KGgoAAAANSUhEUgAAACoAAAArCAMAAAA5QerMAAAABGdBTUEAALGPC/xhBQAAACBjSFJNAAB6JgAAgIQAAPoAAACA6AAAdTAAAOpgAAA6mAAAF3CculE8AAABTVBMVEUAAACgoKDy8vL+/v7q6urx8fHQ0NAzMzPo6Oj09PT+/v739/fg4OCsrKzv7+/n5+fOzs55eXnx8fH5+flVVVXv7+/09PSrq6vW1tb09PTk5OTj4+P8/Pz29vb+/v44ODj6+vpISEj5+fk8PDzv7+/f39/09PTf39/X19fy8vLe3t7g4ODq6urp6en39/fk5OTi4uLt7e0/Pz/u7u7t7e0AAADz8/P39/fo6Ojl5eW+vr7IyMjy8vLu7u67u7v9/f3X19f4+Pjx8fH4+Pj8/Pyfn5/9/f21tbXW1tbv7+/w8PDb29u5ubnr6+vt7e2+vr7n5+fq6urr6+vq6upISEhra2vl5eX5+fnm5uZycnLc3Nz6+vra2tpVVVX19fVIJCTx8fHw8PDs7Ozr6+vGxsbFxcXn5+fn5+fy8vLy8vIqKir+/v7////+/v4AAAAGVb6tAAAAbHRSTlMAM2hwhoFXBWbg9+ZDIsaMRBfUqgymsitSdbDF7OTvCesV6RHcu+SkW2lXXMrJ5728ZgS6ugPh5YmZQ0u0vybtLefe6O0g7yYsy9AyMJKWN2C9wmQHE3joexRv6nAPtAfBwZSTLSyFhN/eBuctnUR8AAAAAWJLR0QAiAUdSAAAAAlwSFlzAAAHOgAABzoBqsXEHQAAAAd0SU1FB+MEExAIHCvW6AoAAAFSSURBVDjLjdRnU8JAEIDhU6wXe68RsXfBXhF7710Be4G9///VIzgkuctu8n7lmZ2dZANjakXFoZLSUFk586uikoOVUUXD6pp/KOO1dYSsbyhAEBI3NqG0GZRaMNnK3VAAb0NoO2h1ILRTp10I7dap2eNNwzqFXm8a0SXv86b9Hgsguw7knru7QYSG9KlDCB3Wp44gdFSfOobQcXWqgAmETupTDYRO6XQaoVGdRhEam1GukM/OMax5N11geItuukTQZdcGfIWgbNVJ1yjJ1iP2a4hvkFQeYoEmaMk2bbrlQw171W1a7uw6voA9Su4fOJ/A4REKj09M5cWennm52PmFcgEWvry6VuDNbSJ/y8ppy+7uH5zy8QmIws8FmExxIOOpZF6mX8C317RF30AIGsrf33Pyg/sPlTt8SvoVRAr4lvQHRBD8K6kZBFr/iZmsGahs5g+sJWZwzyUL0gAAAABJRU5ErkJggg=="/>
                        </svg>
                        <br>Кабинет
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" style="position: relative;"
                       href="<@spring.url "/"/>order/create">
                        <div > <svg  xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="50" height="50" viewBox="0 0 50 50">
                            <metadata><?xpacket begin="﻿" id="W5M0MpCehiHzreSzNTczkc9d"?>
                                <x:xmpmeta xmlns:x="adobe:ns:meta/" x:xmptk="Adobe XMP Core 5.6-c142 79.160924, 2017/07/13-01:06:39        ">
                                    <rdf:RDF xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#">
                                        <rdf:Description rdf:about=""/>
                                    </rdf:RDF>
                                </x:xmpmeta><?xpacket end="w"?></metadata>
                            <image id="Слой_1" data-name="Слой 1" y="8" width="48" height="48" xlink:href="data:img/png;base64,iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAMAAABg3Am1AAAABGdBTUEAALGPC/xhBQAAACBjSFJNAAB6JgAAgIQAAPoAAACA6AAAdTAAAOpgAAA6mAAAF3CculE8AAABzlBMVEUAAADr6+vt7e3+/v78/Pzw8PDc3NzR0dH+/v7d3d3t7e0qKirBwcH09PTS0tLn5+ft7e3w8PDMzMzm5ubz8/NlZWXn5+fZ2dnPz8/j4+NcXFzu7u7r6+vl5eXW1tbS0tLk4uJfX1/u7u7t7e1qamrk5OTg4ODp6elnZ2fu7u7l5eXh4eFjY2MzMzP39/f8/Pxra2vj4+PT09PPz8/h4eHa2tri4uLBwcFtbW3t7e15eXn9/f309PQAAADv7+9hYWHj4+Pk5OTh4eHu7u6RkZHd3d2mpqbm5uZubm7r6+vo6Ojk5OTx8fFZWVk4ODj4+PhfX1/g4ODNzc3V1dXj4+Pe3t7q6uri4uK7u7tvb2/q6up7e3vy8vLx8fFUVFTk5OTj4+Pf39/Jycnv7++Kiorr6+u0tLTm5uZwcHDo6Ojk5OTz8/P6+vpOTk7e3t7R0dHk5OTs7Ox4eHjm5uXg4ODMzMzQ0NDl5eVIJCTz8/PMzMxVVVXY2Nj7+/vg4OCdnZ36+vrm5ubm5ubo6Ojm5ubm5ubk5OT09PPz8/P09PTz8vLz8/Pl5eXl5eWRkZHx8fHz8/ONjY2VlZXU1NTU1NTk5OT////p6enz8/MAAADzQGKwAAAAlXRSTlMAM87v7N6rTveJzwZH2Uo20DNMvd0ZjFlVkhbZ1Y5YVpEY19cYkanMG9aDaBcF5O4Tk1dQpVqrSxzVF+/hAtsVbn+V0ypcN78e05Ff3BQJ6BCXU1eeXoqzRCDRHd3eEnR6mVHZI4A+uiLQmN/qDZx8YXwkyZlRU6MH1m8MPPOoPOuJlJWHiInh4uPg45WUHNbVGx26uT3ZjawAAAABYktHRACIBR1IAAAACXBIWXMAAAc6AAAHOgGqxcQdAAAAB3RJTUUH4wQTEBArEXDVXAAAAaxJREFUSMeVk/s7FGEYhicj3rYokt0sIqciUslhSSUbtYSOzuecaitKxcopcsoSeuyf2zbTXjHf98613/PTPPe89zXfO9eMdiJGNxJ7Mi5eiya/ATIV0KlohEPAYVycPpNAiVEIZ885kv5dJtP5qA71Pyl0QU1IhVNNcOGimpBGbsUl0lWXyECmmnAJWWpCNl1WXCKHctWEPOj2ybcIzsiXyAQFFuEKXbU7QCGKrMhN1/j54pLrpVZ2Azd54RbKBHYbGbxQjgqBVVIVO++prrkj0lq6ywn3cF9C6+DihAdUL6FepDLzD6lBhhvpESM8hk/Km6hZyp+0xLZKb7ThqZQ/w3P5k1/gpZS/ona50EGdMtxF3dzb66FeCe1DPycMYFBCh2iYE3x4LcIRGuXmtTEaF+EEvKygvZH8dfTWzwvvZD/2e35e+4BJTSlT9FFN0Gp0v5rwCdNqwmd8URO+ztBsQMmY+ya+2XlbYwFhAxHLKIseO2EJy4HAd6wYZdUsP+yENT28g19fN8qGWTbthK2jwrHC5Kd5im2xMAnu/N1z95dYuOzth0IHQUn5A0byZBcVsLr2AAAAAElFTkSuQmCC"/>
                            <div style="position: absolute;top:0px;right: 0px;" onclick="updateBasketElement(event)"
                               class="nav-link"
                               id="basket"
                               href="<@spring.url "/"/>order/create">0</div>
                        </svg>
                        </div>
                        Корзина
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">
                        <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="50" height="50" viewBox="0 0 50 50">
                            <metadata><?xpacket begin="﻿" id="W5M0MpCehiHzreSzNTczkc9d"?>
                                <x:xmpmeta xmlns:x="adobe:ns:meta/" x:xmptk="Adobe XMP Core 5.6-c142 79.160924, 2017/07/13-01:06:39        ">
                                    <rdf:RDF xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#">
                                        <rdf:Description rdf:about=""/>
                                    </rdf:RDF>
                                </x:xmpmeta><?xpacket end="w"?></metadata>
                            <image id="Слой_1" data-name="Слой 1" x="7" y="8" width="36" height="44" xlink:href="data:img/png;base64,iVBORw0KGgoAAAANSUhEUgAAACQAAAAsCAQAAACnWtJ+AAAABGdBTUEAALGPC/xhBQAAACBjSFJNAAB6JgAAgIQAAPoAAACA6AAAdTAAAOpgAAA6mAAAF3CculE8AAAAAmJLR0QAAKqNIzIAAAAJcEhZcwAABJ0AAASdAXw0a6EAAAAHdElNRQfjBBMQFxYGWQ+KAAACsklEQVRIx8WWW0gUURjH/+fspQV3kzTdKDFNktRIIktLlsoyxMAHwwhSKoICU5+rFwnyrZcMiiAfip5MgtT0pTCysourFBYp4R2xVt1ddXTd3Tmnh21tZ9acmXWr/8uc78yc3/ku52MOwS/V0hlDnA4atJ7Pitd84AGLBB4PsgtzJnfRuKCtSiIfT//c0F09sDzTXz39kgnMzzWKLYmCo72vAAD0QPvxzWdjst2zL5qGvzKm3iHjuuz8vMPxhwRv20DxOM6YJuuZ1z12LlNLfoI6ny842ezz0lqKxk3jXZzXV0aCAYDHdZy/utdopFaDwQzY30QKWnwLWBLNhFICAnBfpCDuB3QEoJEC5NJLzYP6nD3WZLbqaaJ8Yqjzo923KqgjxdfGDUq7Ex+3mb6sCnLALMCoGIdXDDtvMlDVUEKBOQ6gHAgEGBxRDgCMUM7IjMM9qgB6JOJbZMn+W1XrMKXlJpmUFg0v9nWXLMhAHokpZMU/JTFKoMT52CN4LwtNun2sc86lHIZrhoR9JfPINti4tUwRtIUnhZdfnpCTorJHKyl6VZOGlmksOmbNICG9trhgv988pwIkDa1nm7FF3rGDl5uTVICk5vDU0i1vQugMZ5ZnqkKTmjumy6+kSbrfhZvuCEDgDwU1y8IVtapFD+RZOyMAUmz1fx7afwNd+MM/RiOoP7fier9tpTd6bSByKe/00E50rtkjQ82dalNFFDxKdeF2zco5EjhEwGjRBvwtvwXw+gE6uORxAbaSSEHWIsA5Msb0Dc6y1zz3VOWnJ+k9E1wbJIt2HS0sZ05Ty0U/AVoP7K/bsG/B39clOLgGFNVt3J6xmwojTb1XT/wAANhzehvE78yj+XrsFic/3OhNAZYv7HdjU5NH9+oU/7Gh4twzVfyu1VE1HwKCfKyaFhz8BFc7TcnVRLh5AAAAAElFTkSuQmCC"/>
                        </svg>
                        <br>Заказ
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<@spring.url "/"/>logout" onclick="putBasket([])">
                        <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="50" height="50" viewBox="0 0 50 50">
                            <metadata><?xpacket begin="﻿" id="W5M0MpCehiHzreSzNTczkc9d"?>
                                <x:xmpmeta xmlns:x="adobe:ns:meta/" x:xmptk="Adobe XMP Core 5.6-c142 79.160924, 2017/07/13-01:06:39        ">
                                    <rdf:RDF xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#">
                                        <rdf:Description rdf:about=""/>
                                    </rdf:RDF>
                                </x:xmpmeta><?xpacket end="w"?></metadata>
                            <image id="Слой_1" data-name="Слой 1" y="8" width="43" height="43" xlink:href="data:img/png;base64,iVBORw0KGgoAAAANSUhEUgAAADIAAAAyCAMAAAAp4XiDAAAABGdBTUEAALGPC/xhBQAAACBjSFJNAAB6JgAAgIQAAPoAAACA6AAAdTAAAOpgAAA6mAAAF3CculE8AAAAtFBMVEUAAADV1dX+/v7+/v7V1dWzs7Px8fHFxcX+/v7ExMTb29vl5eVIJCTq6uru7u5ISEhjY2Pw8PDw8PA4ODjw8PDw8PBFRUXx8fHx8fHx8fFVVVVycnLw8PDx8fHo6Ojw8PDr6+t5eXnx8fHy8vJMTEzv7+/w8PDw8PDw8PDw8PA/Pz9/f3/u7u4zMzPv7+/t7e3i4uLm5ubDw8Px8fEEBASNjY3u7u7///+Pj4/v7+/x8fEAAACaMxkEAAAANHRSTlMAdO/3dSXeaudol54Huq8HEsGzCbS1C7fBuAwUw8u4v7gXyrEKxrCvxq0IGKsFx8CspmbdNcCnTgAAAAFiS0dEAIgFHUgAAAAJcEhZcwAABzoAAAc6AarFxB0AAAAHdElNRQfjBBMSDx0QFJo1AAAA7klEQVRIx+3WRxLCMAwFUGF6DRAIvYTeOwi4/8FIIMw4MIP9F5QFf+fFW2hsyaLd/sDKHAIk5chCnWAwJJGTCJMyYRGRTizUgkiIP8FINAYTiuOEPkASyRRK0pwxQJLNcd4Ea/EZzfIdUzAx4pqihRHXlCyMULbMlSpGqFa/GeT2PQM9mFrDNY+k+Xo6MbeeSBsnL2N3uNuDiN3ngQGV7wmAOGJ4bQFtYo/uTaNLHDH2WlOT2HUeTwgh0xHP5oSQ6UISemSJj4vVGh5K/ryPbGASxz+Ln/34vkA0156tdNJaroRvudrtz+oV7iyvcBcyYCvkqVSWCQAAAABJRU5ErkJggg=="/>
                        </svg>

                        <br>Выход
                    </a>
                </li>
            </#if>
             <#if !model.user.isPresent()>
                <li class="nav-item">
                    <a class="nav-link" href="<@spring.url "/"/>login">
                        <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="50" height="50" viewBox="0 0 50 50">
                            <metadata><?xpacket begin="﻿" id="W5M0MpCehiHzreSzNTczkc9d"?>
                                <x:xmpmeta xmlns:x="adobe:ns:meta/" x:xmptk="Adobe XMP Core 5.6-c142 79.160924, 2017/07/13-01:06:39        ">
                                    <rdf:RDF xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#">
                                        <rdf:Description rdf:about=""/>
                                    </rdf:RDF>
                                </x:xmpmeta><?xpacket end="w"?></metadata>
                            <image id="Слой_1" data-name="Слой 1" x="5" y="8" width="42" height="43" xlink:href="data:img/png;base64,iVBORw0KGgoAAAANSUhEUgAAACoAAAArCAMAAAA5QerMAAAABGdBTUEAALGPC/xhBQAAACBjSFJNAAB6JgAAgIQAAPoAAACA6AAAdTAAAOpgAAA6mAAAF3CculE8AAABTVBMVEUAAACgoKDy8vL+/v7q6urx8fHQ0NAzMzPo6Oj09PT+/v739/fg4OCsrKzv7+/n5+fOzs55eXnx8fH5+flVVVXv7+/09PSrq6vW1tb09PTk5OTj4+P8/Pz29vb+/v44ODj6+vpISEj5+fk8PDzv7+/f39/09PTf39/X19fy8vLe3t7g4ODq6urp6en39/fk5OTi4uLt7e0/Pz/u7u7t7e0AAADz8/P39/fo6Ojl5eW+vr7IyMjy8vLu7u67u7v9/f3X19f4+Pjx8fH4+Pj8/Pyfn5/9/f21tbXW1tbv7+/w8PDb29u5ubnr6+vt7e2+vr7n5+fq6urr6+vq6upISEhra2vl5eX5+fnm5uZycnLc3Nz6+vra2tpVVVX19fVIJCTx8fHw8PDs7Ozr6+vGxsbFxcXn5+fn5+fy8vLy8vIqKir+/v7////+/v4AAAAGVb6tAAAAbHRSTlMAM2hwhoFXBWbg9+ZDIsaMRBfUqgymsitSdbDF7OTvCesV6RHcu+SkW2lXXMrJ5728ZgS6ugPh5YmZQ0u0vybtLefe6O0g7yYsy9AyMJKWN2C9wmQHE3joexRv6nAPtAfBwZSTLSyFhN/eBuctnUR8AAAAAWJLR0QAiAUdSAAAAAlwSFlzAAAHOgAABzoBqsXEHQAAAAd0SU1FB+MEExAIHCvW6AoAAAFSSURBVDjLjdRnU8JAEIDhU6wXe68RsXfBXhF7710Be4G9///VIzgkuctu8n7lmZ2dZANjakXFoZLSUFk586uikoOVUUXD6pp/KOO1dYSsbyhAEBI3NqG0GZRaMNnK3VAAb0NoO2h1ILRTp10I7dap2eNNwzqFXm8a0SXv86b9Hgsguw7knru7QYSG9KlDCB3Wp44gdFSfOobQcXWqgAmETupTDYRO6XQaoVGdRhEam1GukM/OMax5N11geItuukTQZdcGfIWgbNVJ1yjJ1iP2a4hvkFQeYoEmaMk2bbrlQw171W1a7uw6voA9Su4fOJ/A4REKj09M5cWennm52PmFcgEWvry6VuDNbSJ/y8ppy+7uH5zy8QmIws8FmExxIOOpZF6mX8C317RF30AIGsrf33Pyg/sPlTt8SvoVRAr4lvQHRBD8K6kZBFr/iZmsGahs5g+sJWZwzyUL0gAAAABJRU5ErkJggg=="/>
                        </svg>
                        <br>Кабинет
                    </a>
                </li>
                 <li class="nav-item">
                     <a
                             class="nav-link"
                             href="<@spring.url "/"/>login">
                         <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="50" height="50" viewBox="0 0 50 50">
                             <metadata><?xpacket begin="﻿" id="W5M0MpCehiHzreSzNTczkc9d"?>
                                 <x:xmpmeta xmlns:x="adobe:ns:meta/" x:xmptk="Adobe XMP Core 5.6-c142 79.160924, 2017/07/13-01:06:39        ">
                                     <rdf:RDF xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#">
                                         <rdf:Description rdf:about=""/>
                                     </rdf:RDF>
                                 </x:xmpmeta><?xpacket end="w"?></metadata>
                             <image id="Слой_1" data-name="Слой 1" y="8" width="48" height="48" xlink:href="data:img/png;base64,iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAMAAABg3Am1AAAABGdBTUEAALGPC/xhBQAAACBjSFJNAAB6JgAAgIQAAPoAAACA6AAAdTAAAOpgAAA6mAAAF3CculE8AAABzlBMVEUAAADr6+vt7e3+/v78/Pzw8PDc3NzR0dH+/v7d3d3t7e0qKirBwcH09PTS0tLn5+ft7e3w8PDMzMzm5ubz8/NlZWXn5+fZ2dnPz8/j4+NcXFzu7u7r6+vl5eXW1tbS0tLk4uJfX1/u7u7t7e1qamrk5OTg4ODp6elnZ2fu7u7l5eXh4eFjY2MzMzP39/f8/Pxra2vj4+PT09PPz8/h4eHa2tri4uLBwcFtbW3t7e15eXn9/f309PQAAADv7+9hYWHj4+Pk5OTh4eHu7u6RkZHd3d2mpqbm5uZubm7r6+vo6Ojk5OTx8fFZWVk4ODj4+PhfX1/g4ODNzc3V1dXj4+Pe3t7q6uri4uK7u7tvb2/q6up7e3vy8vLx8fFUVFTk5OTj4+Pf39/Jycnv7++Kiorr6+u0tLTm5uZwcHDo6Ojk5OTz8/P6+vpOTk7e3t7R0dHk5OTs7Ox4eHjm5uXg4ODMzMzQ0NDl5eVIJCTz8/PMzMxVVVXY2Nj7+/vg4OCdnZ36+vrm5ubm5ubo6Ojm5ubm5ubk5OT09PPz8/P09PTz8vLz8/Pl5eXl5eWRkZHx8fHz8/ONjY2VlZXU1NTU1NTk5OT////p6enz8/MAAADzQGKwAAAAlXRSTlMAM87v7N6rTveJzwZH2Uo20DNMvd0ZjFlVkhbZ1Y5YVpEY19cYkanMG9aDaBcF5O4Tk1dQpVqrSxzVF+/hAtsVbn+V0ypcN78e05Ff3BQJ6BCXU1eeXoqzRCDRHd3eEnR6mVHZI4A+uiLQmN/qDZx8YXwkyZlRU6MH1m8MPPOoPOuJlJWHiInh4uPg45WUHNbVGx26uT3ZjawAAAABYktHRACIBR1IAAAACXBIWXMAAAc6AAAHOgGqxcQdAAAAB3RJTUUH4wQTEBArEXDVXAAAAaxJREFUSMeVk/s7FGEYhicj3rYokt0sIqciUslhSSUbtYSOzuecaitKxcopcsoSeuyf2zbTXjHf98613/PTPPe89zXfO9eMdiJGNxJ7Mi5eiya/ATIV0KlohEPAYVycPpNAiVEIZ885kv5dJtP5qA71Pyl0QU1IhVNNcOGimpBGbsUl0lWXyECmmnAJWWpCNl1WXCKHctWEPOj2ybcIzsiXyAQFFuEKXbU7QCGKrMhN1/j54pLrpVZ2Azd54RbKBHYbGbxQjgqBVVIVO++prrkj0lq6ywn3cF9C6+DihAdUL6FepDLzD6lBhhvpESM8hk/Km6hZyp+0xLZKb7ThqZQ/w3P5k1/gpZS/ona50EGdMtxF3dzb66FeCe1DPycMYFBCh2iYE3x4LcIRGuXmtTEaF+EEvKygvZH8dfTWzwvvZD/2e35e+4BJTSlT9FFN0Gp0v5rwCdNqwmd8URO+ztBsQMmY+ya+2XlbYwFhAxHLKIseO2EJy4HAd6wYZdUsP+yENT28g19fN8qGWTbthK2jwrHC5Kd5im2xMAnu/N1z95dYuOzth0IHQUn5A0byZBcVsLr2AAAAAElFTkSuQmCC"/>
                         </svg>
                         <br>Корзина
                     </a>
                 </li>
                 <a class="nav-link" href="<@spring.url "/"/>login">
                     <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="50" height="50" viewBox="0 0 50 50">
                         <metadata><?xpacket begin="﻿" id="W5M0MpCehiHzreSzNTczkc9d"?>
                             <x:xmpmeta xmlns:x="adobe:ns:meta/" x:xmptk="Adobe XMP Core 5.6-c142 79.160924, 2017/07/13-01:06:39        ">
                                 <rdf:RDF xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#">
                                     <rdf:Description rdf:about=""/>
                                 </rdf:RDF>
                             </x:xmpmeta><?xpacket end="w"?></metadata>
                         <image id="Слой_1" data-name="Слой 1" x="7" y="8" width="36" height="44" xlink:href="data:img/png;base64,iVBORw0KGgoAAAANSUhEUgAAACQAAAAsCAQAAACnWtJ+AAAABGdBTUEAALGPC/xhBQAAACBjSFJNAAB6JgAAgIQAAPoAAACA6AAAdTAAAOpgAAA6mAAAF3CculE8AAAAAmJLR0QAAKqNIzIAAAAJcEhZcwAABJ0AAASdAXw0a6EAAAAHdElNRQfjBBMQFxYGWQ+KAAACsklEQVRIx8WWW0gUURjH/+fspQV3kzTdKDFNktRIIktLlsoyxMAHwwhSKoICU5+rFwnyrZcMiiAfip5MgtT0pTCysourFBYp4R2xVt1ddXTd3Tmnh21tZ9acmXWr/8uc78yc3/ku52MOwS/V0hlDnA4atJ7Pitd84AGLBB4PsgtzJnfRuKCtSiIfT//c0F09sDzTXz39kgnMzzWKLYmCo72vAAD0QPvxzWdjst2zL5qGvzKm3iHjuuz8vMPxhwRv20DxOM6YJuuZ1z12LlNLfoI6ny842ezz0lqKxk3jXZzXV0aCAYDHdZy/utdopFaDwQzY30QKWnwLWBLNhFICAnBfpCDuB3QEoJEC5NJLzYP6nD3WZLbqaaJ8Yqjzo923KqgjxdfGDUq7Ex+3mb6sCnLALMCoGIdXDDtvMlDVUEKBOQ6gHAgEGBxRDgCMUM7IjMM9qgB6JOJbZMn+W1XrMKXlJpmUFg0v9nWXLMhAHokpZMU/JTFKoMT52CN4LwtNun2sc86lHIZrhoR9JfPINti4tUwRtIUnhZdfnpCTorJHKyl6VZOGlmksOmbNICG9trhgv988pwIkDa1nm7FF3rGDl5uTVICk5vDU0i1vQugMZ5ZnqkKTmjumy6+kSbrfhZvuCEDgDwU1y8IVtapFD+RZOyMAUmz1fx7afwNd+MM/RiOoP7fier9tpTd6bSByKe/00E50rtkjQ82dalNFFDxKdeF2zco5EjhEwGjRBvwtvwXw+gE6uORxAbaSSEHWIsA5Msb0Dc6y1zz3VOWnJ+k9E1wbJIt2HS0sZ05Ty0U/AVoP7K/bsG/B39clOLgGFNVt3J6xmwojTb1XT/wAANhzehvE78yj+XrsFic/3OhNAZYv7HdjU5NH9+oU/7Gh4twzVfyu1VE1HwKCfKyaFhz8BFc7TcnVRLh5AAAAAElFTkSuQmCC"/>
                     </svg>
                     <br>Заказ
                 </a>
             </#if>
        </ul>
    </div>
</nav>
<div class="nav-scroller py-1 mb-2">
    <nav class="nav d-flex justify-content-between">
        <a class="p-2 text-muted" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        Книги
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
            <a class="dropdown-item" href="<@spring.url "/"/>books/all">Воспитание</a>
            <a class="dropdown-item" href="<@spring.url "/"/>books/all">Образование</a>
            <a class="dropdown-item" href="<@spring.url "/"/>books/all">Дом.Быт</a>
            <a class="dropdown-item" href="<@spring.url "/"/>books/all">Наука</a>
            <a class="dropdown-item" href="<@spring.url "/"/>books/all">Детская литература</a>
            <a class="dropdown-item" href="<@spring.url "/"/>books/all">Медицина</a>
            <a class="dropdown-item" href="<@spring.url "/"/>books/all">Право</a>
            <a class="dropdown-item" href="<@spring.url "/"/>books/all">Прикладные науки</a>
            <a class="dropdown-item" href="<@spring.url "/"/>books/all">Филология</a>
            <a class="dropdown-item" href="<@spring.url "/"/>books/all">Художетсвенная литература</a>
        </div>
        <a class="p-2 text-muted" href="#">Доставка и оплата</a>
        <a class="p-2 text-muted" href="#">Новинки</a>
        <a class="p-2 text-muted" href="#">Вопрос-ответ</a>
        <a class="p-2 text-muted" href="#">Скидки</a>
        <a class="p-2 text-muted" href="#">Контакты</a>
    </nav>
</div>