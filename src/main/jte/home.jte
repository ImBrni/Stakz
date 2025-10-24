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
                <div class="absolute bottom-4 left-4 p-2 bg-black bg-opacity-75 rounded-md text-2xl">${item.get("name")}</div>
            </div>
        </a>
    @endfor
</main>

@template.modules.footer(currentUser = currentUser, enabled = true)

</body>
</html>