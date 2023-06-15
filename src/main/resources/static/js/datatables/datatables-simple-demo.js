window.addEventListener('DOMContentLoaded', event => {
    // Simple-DataTables
    // https://github.com/fiduswriter/Simple-DataTables/wiki

    const datatablesSimple = document.getElementById('datatablesSimple');
    if (datatablesSimple) {
        new simpleDatatables.DataTable(datatablesSimple);
    }

      //제공된 테이블이 초기화된 후 "datatable-sorter" 클래스 제거
     $(document).ready(function() {
         $('a.datatable-sorter').removeClass('datatable-sorter');
     });
});
window.addEventListener('DOMContentLoaded', event => {
const tdElements = document.querySelectorAll('td[id]');
tdElements.forEach(td => {
    const itemId = td.textContent.trim();
    td.id = itemId;
});
});

window.addEventListener('DOMContentLoaded', event => {
    const checkboxes = document.querySelectorAll('input.myCheckbox');
    const selectedValues = [];

    checkboxes.forEach(checkbox => {
        checkbox.addEventListener('change', () => {
            selectedValues.length = 0; // 배열 초기화

            checkboxes.forEach(checkbox => {
                if (checkbox !== document.getElementById('checkAll') && checkbox.checked) {
                    const row = checkbox.parentNode.parentNode;
                    console.log(row);
                    const nextColumn = checkbox.parentNode.nextElementSibling;
                    console.log(1+nextColumn);
                    const nextColumnValue = nextColumn.textContent.trim();

                    console.log(2+nextColumnValue);
                    if (!selectedValues.includes(nextColumnValue)) {
                        selectedValues.push(nextColumnValue);
                    }
                }
            });
            console.log('선택된 다음 열 값들:', selectedValues);
        });
    });
});
