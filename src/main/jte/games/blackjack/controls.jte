
@param String endpoint = "blackjack/tick"

@param boolean ddouble = false
@param boolean hit = false
@param boolean fold = false

@param boolean bet = false
@param boolean start = false

<form fx-method="POST" fx-action="${endpoint}" class="w-2/3 sm:w-1/3 flex flex-row justify-center items-center gap-4">

    <input type="text" name="bet" disabled="${!bet}" placeholder="Bet amount"/>

    @if(start)
        @template.modules.button(label = "Start", type = "submit")
    @else
        @if(ddouble)
            <input type="radio" name="paction" value="double"/>
        @endif

        @if(hit)
            <input type="radio" name="paction" value="hit"/>
        @endif

        @if(fold)
            <input type="radio" name="paction" value="stand"/>
        @endif
    @endif
</form>

<!--
<fieldset class="space-y-3">
    <legend class="sr-only">Moves:</legend>
    <div>
        <label for="DeliveryPriority" class="flex items-center justify-center gap-4 rounded border border-gray-300 bg-white p-3 text-sm font-medium shadow-sm transition-colors hover:bg-gray-50 has-checked:border-blue-600 has-checked:ring-1 has-checked:ring-blue-600 dark:border-gray-600 dark:bg-gray-900 dark:hover:bg-gray-800" >
            <p class="text-gray-700 dark:text-gray-200">Double</p>
            <input type="radio" name="paction" value="double" class="sr-only" />
        </label>
    </div>
    <div>
        <label for="DeliveryPriority" class="flex items-center justify-center gap-4 rounded border border-gray-300 bg-white p-3 text-sm font-medium shadow-sm transition-colors hover:bg-gray-50 has-checked:border-blue-600 has-checked:ring-1 has-checked:ring-blue-600 dark:border-gray-600 dark:bg-gray-900 dark:hover:bg-gray-800" >
            <p class="text-gray-700 dark:text-gray-200">Hit</p>
            <input type="radio" name="paction" value="hit" class="sr-only" />
        </label>
    </div>
    <div>
        <label for="DeliveryPriority" class="flex items-center justify-center gap-4 rounded border border-gray-300 bg-white p-3 text-sm font-medium shadow-sm transition-colors hover:bg-gray-50 has-checked:border-blue-600 has-checked:ring-1 has-checked:ring-blue-600 dark:border-gray-600 dark:bg-gray-900 dark:hover:bg-gray-800" >
            <p class="text-gray-700 dark:text-gray-200">Stand</p>
            <input type="radio" name="paction" value="stand" class="sr-only" />
        </label>
    </div>
</fieldset>
-->