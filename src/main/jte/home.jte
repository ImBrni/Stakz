@param casino.model.AppUser currentUser
@param java.util.List<java.util.Map<String, String>> games

<html>
@template.modules.head()
<body class="bg-slate-600 text-white h-screen flex items-center justify-center">
@template.modules.header(currentUser = currentUser)

<main class="flex flex-wrap justify-center gap-4 max-w-3xl mx-auto">
    @for(var item : games)
        <a href="/games/${item.get("uri")}">
            <div class="flex-1 min-w-[300px] min-h-[200px] bg-[url(${item.get("banneruri")})] bg-auto p-4 rounded-lg relative">
                <p class="absolute bottom-4 left-4">${item.get("name")}</p>
            </div>
        </a>
    @endfor
</main>

@template.modules.footer()

</body>
</html>