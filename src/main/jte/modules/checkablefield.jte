@param int number
@param String name

<div class="checkbox-wrapper-10">
    <input class="tgl tgl-flip" id="${number}" name="${name}" type="checkbox" checked />
    <label class="tgl-btn" data-tg-off="${number}" data-tg-on="${number}" for="${number}"></label>
</div>

<style>
    .checkbox-wrapper-10 .tgl {
      display: none;
    }
    .checkbox-wrapper-10 .tgl,
    .checkbox-wrapper-10 .tgl:after,
    .checkbox-wrapper-10 .tgl:before,
    .checkbox-wrapper-10 .tgl *,
    .checkbox-wrapper-10 .tgl *:after,
    .checkbox-wrapper-10 .tgl *:before,
    .checkbox-wrapper-10 .tgl + .tgl-btn {
      box-sizing: border-box;
    }
    .checkbox-wrapper-10 .tgl::-moz-selection,
    .checkbox-wrapper-10 .tgl:after::-moz-selection,
    .checkbox-wrapper-10 .tgl:before::-moz-selection,
    .checkbox-wrapper-10 .tgl *::-moz-selection,
    .checkbox-wrapper-10 .tgl *:after::-moz-selection,
    .checkbox-wrapper-10 .tgl *:before::-moz-selection,
    .checkbox-wrapper-10 .tgl + .tgl-btn::-moz-selection,
    .checkbox-wrapper-10 .tgl::selection,
    .checkbox-wrapper-10 .tgl:after::selection,
    .checkbox-wrapper-10 .tgl:before::selection,
    .checkbox-wrapper-10 .tgl *::selection,
    .checkbox-wrapper-10 .tgl *:after::selection,
    .checkbox-wrapper-10 .tgl *:before::selection,
    .checkbox-wrapper-10 .tgl + .tgl-btn::selection {
      background: none;
    }
    .checkbox-wrapper-10 .tgl + .tgl-btn {
      outline: 0;
      display: block;
      width: 8em;
      height: 6em;
      position: relative;
      cursor: pointer;
      -webkit-user-select: none;
         -moz-user-select: none;
          -ms-user-select: none;
              user-select: none;
    }
    .checkbox-wrapper-10 .tgl + .tgl-btn:after,
    .checkbox-wrapper-10 .tgl + .tgl-btn:before {
      position: relative;
      display: block;
      content: "";
      width: 50%;
      height: 100%;
    }

    .checkbox-wrapper-10 .tgl-flip + .tgl-btn {
      padding: 2px;
      transition: all 0.2s ease;
      font-family: sans-serif;
      perspective: 100px;
    }
    .checkbox-wrapper-10 .tgl-flip + .tgl-btn:after,
    .checkbox-wrapper-10 .tgl-flip + .tgl-btn:before {
      display: inline-block;
      transition: all 0.4s ease;
      width: 100%;
      text-align: center;
      position: absolute;
      line-height: 2em;
      font-weight: bold;
      color: #fff;
      position: absolute;
      top: 0;
      left: 0;
      -webkit-backface-visibility: hidden;
              backface-visibility: hidden;
      border-radius: 4px;
    }
    .checkbox-wrapper-10 .tgl-flip + .tgl-btn:after {
      content: attr(data-tg-on);
      background: #7CB342;
    }
    .checkbox-wrapper-10 .tgl-flip + .tgl-btn:before {
      background: #7CB342;
      content: attr(data-tg-off);
    }
    .checkbox-wrapper-10 .tgl-flip:checked + .tgl-btn:after {
      left: 0;
      background: gray;
    }
</style>
