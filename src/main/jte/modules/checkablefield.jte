@param int number
@param String additional

<div class="checkbox-wrapper-10">
    <input type="checkbox" id="${number}" class="tri-state-checkbox ${additional}">
    <label for="${number}">${number}</label>
</div>

<style>
.tri-state-checkbox {
  position: absolute;
  opacity: 0;
  width: 0;
  height: 0;
}

.tri-state-checkbox + label {
  position: relative;
  display: inline-flex;
  align-items: center;
  justify-content: center;
  width: 4em;      /* Make it big */
  height: 4em;     /* Make it big */
  font-size: 1.5em;   /* Large text */
  font-weight: bold;
  text-align: center;
  background-color: #f0f0f0;
  border: 4px solid #ccc;
  border-radius: 10px;
  cursor: pointer;
  user-select: none;
  transition: all 0.3s ease;
}

.tri-state-checkbox + label {
  background-color: #ffcccc;
  color: #cc0000;
}

.tri-state-checkbox.good + label {
  background-color: #ccffcc;
  color: #006600;
}

.tri-state-checkbox:checked + label {
  background-color: #ccccff;
  color: #0000cc;
  border-color: #0000cc;
}

.tri-state-checkbox + label:hover {
  transform: scale(1.05);
  box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
}

.tri-state-checkbox:focus-visible + label {
  outline: 4px solid #6666ff;
}
</style>
