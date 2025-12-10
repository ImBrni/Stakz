@param casino.model.AppUser currentUser
@param casino.controller.games.mine.Mine minepredictor

@param boolean filler = false

@if(filler)
<html lang="en">
@template.modules.head()
<body>
@template.modules.header(currentUser = currentUser)
@endif

<main id="game" class="flex flex-col gap-4 justify-center items-center h-screen w-screen margin-6">
    Hello from mine!
</main>

@if(filler)
@template.modules.footer(currentUser = currentUser, enabled = true)

</body>
</html>
@endif
