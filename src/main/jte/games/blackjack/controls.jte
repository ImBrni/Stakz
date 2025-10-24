@param boolean _double = false;
@param boolean hit = false;
@param boolean fold = false;

<div class="controls flex gap-6 justify-center max-w-[1000px] items-center h-1/6 w-1/2">
    @if(_double)
        @template.modules.button(label = "Double")
    @endif

    @if(hit)
        @template.modules.button(label = "Hit")
    @endif

    @if(fold)
        @template.modules.button(label = "Fold")
    @endif
</div>