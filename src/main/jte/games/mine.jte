@param casino.model.AppUser currentUser
<%--@param casino.controller.games.mine.Mine mine--%>

@param boolean filler = false

@if(filler)
<html lang="en">
@template.modules.head()
<body>
@template.modules.header(currentUser = currentUser)
@endif

<main id="game" class="flex flex-col gap-4 justify-center items-center h-screen w-screen margin-6">

    <script>

        let play = () => {
            console.log("Hello world!");
        }

    </script>

    <div id="controls" method="post" class="flex flex-col justify-center items-center gap-4">

        <div class="grid grid-cols-6 gap-4">
        @for(int i = 0; i < (6*6); ++i)
            @template.modules.checkablefield(number = i, name = "grid")
        @endfor
        </div>

        @template.modules.gamecontrols(currentUser = currentUser)
    </div>
</main>

@if(filler)
@template.modules.footer(currentUser = currentUser, enabled = true)

</body>
</html>
@endif
