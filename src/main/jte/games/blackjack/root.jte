@param casino.model.AppUser currentUser

<html lang="en">
@template.modules.head()
<body>
@template.modules.header(currentUser = currentUser)

<script src="/assets/fixi.js"></script>

<main class="flex flex-col gap-4 justify-center items-center h-screen w-screen margin-6">
    <div id="table" class="p-4 mb-10 bg-green-900 text-green-900 w-2/3 h-1/2 sm:w-1/3 sm:h-1/3 rounded-xl">
        Table
    </div>

    <div class="controls contents">
        @template.games.blackjack.controls(start = true, bet = true)
    </div>
</main>

@template.modules.footer(currentUser = currentUser, enabled = true)

</body>
</html>