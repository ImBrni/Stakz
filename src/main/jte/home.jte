@param casino.model.AppUser currentUser
@param java.util.List<java.util.Map<String, String>> games

<html lang="en">
@template.modules.head()
<body>
@template.modules.header(currentUser = currentUser)

<main class="flex flex-wrap justify-center gap-4 max-w-3xl mx-auto">
    @for(var item : games)
        <a href="${item.get("uri")}">
            <div class="flex-1 -z-10 min-w-[300px] min-h-[200px] bg-[url(${item.get("banneruri")})] bg-[length:125%] p-4 rounded-lg relative">
                <p class="absolute bottom-4 p-2 rounded-xl left-4 text-2xl">${item.get("name")}</p>
            </div>
        </a>
    @endfor
</main>

<!--
<ul class="fixed bottom-10 flex gap-4 justify-center content-center">
    <div class="bg-black rounded-md p-4">10,000,000$</div>
    <li class="relative group" tabindex="-1">
        <button class="bg-black rounded-md p-4">Menu</button>
        <div class="absolute z-50 bg-black p-4 rounded-md invisible w-48 opacity-0 -top-[100px] right-1/3 transform transition-all group-focus-within:visible group-focus-within:opacity-100">
            <div class="flex flex-col gap-2">
                <p>1</p>
                <p>2</p>
            </div>
        </div>
    </li>
</ul>
-->

@template.modules.footer(currentUser = currentUser, enabled = true)

</body>
</html>