@param casino.model.AppUser currentUser

@param boolean canBet = true
@param String playbuttoncustomclass = ""


<div id="controls" class="w-2/3 sm:w-1/3 flex flex-col sm:flex-row justify-center items-center gap-4">

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
            @if(canBet)
                <button type="button" onclick="addBet(this)" value="-100" class="whitespace-nowrap mx-4 leading-10 text-gray-600 transition hover:opacity-75 dark:text-gray-300">
                    − 100
                </button>
                <button type="button" onclick="addBet(this)" value="-10" class="whitespace-nowrap mx-4 leading-10 text-gray-600 transition hover:opacity-75 dark:text-gray-300">
                    − 10
                </button>
                <button type="button" onclick="addBet(this)" value="-1" class="whitespace-nowrap mx-4 leading-10 text-gray-600 transition hover:opacity-75 dark:text-gray-300">
                    − 1
                </button>
            @endif

            <input type="number" id="bet" name="bet" disabled="${!canBet}" min="1" value="1"  class="h-10 w-16 border-transparent text-center [-moz-appearance:textfield] sm:text-sm dark:bg-gray-900 dark:text-white [&amp;::-webkit-inner-spin-button]:m-0 [&amp;::-webkit-inner-spin-button]:appearance-none [&amp;::-webkit-outer-spin-button]:m-0 [&amp;::-webkit-outer-spin-button]:appearance-none">

            @if(canBet)
                <button type="button" onclick="addBet(this)" value="+1" class="whitespace-nowrap mx-4 leading-10 text-gray-600 transition hover:opacity-75 dark:text-gray-300">
                    + 1
                </button>
                <button type="button" onclick="addBet(this)" value="+10" class="whitespace-nowrap mx-4 leading-10 text-gray-600 transition hover:opacity-75 dark:text-gray-300">
                    + 10
                </button>
                <button type="button" onclick="addBet(this)" value="+100" class="whitespace-nowrap mx-4 leading-10 text-gray-600 transition hover:opacity-75 dark:text-gray-300">
                    + 100
                </button>
            @endif
        </div>
    </div>

    @template.modules.button(label = "Play", customclass = playbuttoncustomclass)
</div>