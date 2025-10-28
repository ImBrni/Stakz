@param casino.model.AppUser currentUser

<%-- Table --%>
@param java.util.List<casino.games.Card> pcards
@param java.util.List<casino.games.Card> dcards

<%-- Controls --%>
@param String endpoint = "blackjack/tick"
@param boolean ddouble = false
@param boolean hit = false
@param boolean stand = false
@param boolean bet = false
@param long betAmount = 1L
@param boolean start = false

<html lang="en">
@template.modules.head()
<script src="/assets/elements.cardmeister.full.js"></script>
<body>
@template.modules.header(currentUser = currentUser)

<script src="/assets/fixi.js"></script>

<main id="game" class="flex flex-col gap-4 justify-center items-center h-screen w-screen margin-6">
    <div id="table" class="p-4 mb-10 bg-green-900 w-1/2 sm:w-1/3 rounded-xl">

        <div class="dealer flex justify-center items-center flex-row-reverse mb-[50px]">

            @for(var card : dcards)
                <playing-card class="w-[15em] sm:w-[10em]" rank="${card.getRank()}" suit="${card.getSuit()}"></playing-card>
                <!--
                <playing-card class="w-[15em] sm:w-[10em]" rank="0" suit="0"></playing-card>
                -->
            @endfor

        </div>

        <div class="player flex justify-center items-center">

            @for(var card : pcards)
                <playing-card class="w-[15em] sm:w-[10em]" rank="${card.getRank()}" suit="${card.getSuit()}"></playing-card>
                <!--
                <playing-card class="w-[15em] sm:w-[10em]" rank="0" suit="0"></playing-card>
                -->
            @endfor
            <!--
            <playing-card class="w-[15em] sm:w-[10em]" rank="Ace" suit="Hearts"></playing-card>
            <playing-card class="w-[15em] sm:w-[10em]" rank="Queen" suit="Hearts"></playing-card>
            -->

        </div>

    </div>

    <form id="controls" fx-method="POST" fx-target="#game" fx-action="${endpoint}" class="w-2/3 sm:w-1/3 flex flex-col sm:flex-row justify-center items-center gap-4">

        <script>
            function addBet(button) {
              const input = document.getElementById('bet');
              const currentValue = parseInt(input.value, 10) || 0;
              const addValue = parseInt(button.value, 10);
              input.value = Math.max(Math.min(currentValue + addValue, ${currentUser.getBalance()}), 1);
            }

        </script>

        <div>
            <label for="bet" class="sr-only"> Quantity </label>
            <div class="flex items-center rounded-sm border border-gray-200 dark:border-gray-800">
                @if(bet)
                    <button type="button" onclick="addBet(this)" value="-100" class="mx-4 leading-10 text-gray-600 transition hover:opacity-75 dark:text-gray-300">
                        − 100
                    </button>
                    <button type="button" onclick="addBet(this)" value="-10" class="mx-4 leading-10 text-gray-600 transition hover:opacity-75 dark:text-gray-300">
                        − 10
                    </button>
                    <button type="button" onclick="addBet(this)" value="-1" class="mx-4 leading-10 text-gray-600 transition hover:opacity-75 dark:text-gray-300">
                        − 1
                    </button>
                @endif

                <input type="number" id="bet" name="bet" disabled="${!bet}" min="1" value="${betAmount}"  class="h-10 w-16 border-transparent text-center [-moz-appearance:textfield] sm:text-sm dark:bg-gray-900 dark:text-white [&amp;::-webkit-inner-spin-button]:m-0 [&amp;::-webkit-inner-spin-button]:appearance-none [&amp;::-webkit-outer-spin-button]:m-0 [&amp;::-webkit-outer-spin-button]:appearance-none">

                @if(bet)
                    <button type="button" onclick="addBet(this)" value="+1" class="mx-4 leading-10 text-gray-600 transition hover:opacity-75 dark:text-gray-300">
                        + 1
                    </button>
                    <button type="button" onclick="addBet(this)" value="+10" class="mx-4 leading-10 text-gray-600 transition hover:opacity-75 dark:text-gray-300">
                        + 10
                    </button>
                    <button type="button" onclick="addBet(this)" value="+100" class="mx-4 leading-10 text-gray-600 transition hover:opacity-75 dark:text-gray-300">
                        + 100
                    </button>
                @endif
            </div>
        </div>

        @if(start)
            @template.modules.button(label = "Start", type = "submit", name = "paction", value = "start")
        @else
            @if(ddouble)
                @template.modules.button(label = "Double", type = "submit", name = "paction", value = "double")
            @endif
            @if(hit)
                @template.modules.button(label = "Hit", type = "submit", name = "paction", value = "hit")
            @endif
            @if(stand)
                @template.modules.button(label = "Stand", type = "submit", name = "paction", value = "stand")
            @endif
        @endif
    </form>
</main>

@template.modules.footer(currentUser = currentUser, enabled = true)

</body>
</html>
