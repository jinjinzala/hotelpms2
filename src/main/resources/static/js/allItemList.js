
$(document).ready(function() {
    // "checkAll" 체크박스에 클릭 이벤트 핸들러를 추가합니다.
    $('#checkAll').click(function() {
        var isChecked = $(this).is(':checked');

        // "tbody"에 있는 모든 체크박스를 선택 혹은 해제합니다.
        $('tbody .myCheckbox').prop('checked', isChecked);
    });
});

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


//모달창에 입력되는 최소 발주 수량
// const autoOrderQuantityInput = document.getElementById('autoOrderQuantity');
// const autoOrderQuantityValue = autoOrderQuantityInput.value;

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
                    const nextColumnValue = nextColumn.textContent.trim();

                    if (!selectedValues.includes(nextColumnValue)) {
                        selectedValues.push(nextColumnValue);
                    }
                }
            });

            // 변수의 개수에 따라 IF 문 실행
            const count = selectedValues.length;
            console.log("들어오는 배열의 갯수", count);

            const addButton = document.getElementById('add');
            addButton.removeEventListener('click', handleAddButtonClick); // 기존에 등록된 이벤트 리스너 제거
            addButton.addEventListener('click', handleAddButtonClick); // 수정된 이벤트 리스너 등록
        });
    });
    let autoOrderQuantityValue = document.getElementById('autoOrderQuantity').value;
    // 버튼 클릭 이벤트 핸들러
    function handleAddButtonClick() {
        if (selectedValues.length === 1) {
            // 모달 열기
            $('#exampleModalLg').modal('show');
            $('#add').off('click', handleAddButtonClick); // 이벤트 리스너 제거

            document.getElementById('btn-send').addEventListener('click', function() {
                autoOrderQuantityValue =  $('#autoOrderQuantity').val();

                console.log("안연ㅇ엉엉2",autoOrderQuantityValue); // 값을 확인하거나 원하는 로직을 수행합니다.
                $.ajax({
                    type: 'POST',
                    url: '/partnerStock/itemOrderQuantity', // 실제 컨트롤러의 URL로 변경해야 합니다.
                    data: JSON.stringify({
                        itemList: selectedValues,
                        orderQuantity: autoOrderQuantityValue
                    }),
                    contentType: 'application/json',
                    success: function(response) {
                        console.log('전송 완료');
                        console.log('응답:', response);
                        location.reload();
                    },
                    error: function(error) {
                        console.log('전송 실패', selectedValues);
                        console.log('전송 실패');
                        console.log('에러:', error);
                    }
                });
            });


        } else {
            if (selectedValues.length > 1) {
                $.ajax({
                    type: 'POST',
                    url: '/partnerStock/ItemNumberList', // 실제 컨트롤러의 URL로 변경해야 합니다.
                    data: JSON.stringify({ itemList: selectedValues }),
                    contentType: 'application/json',
                    success: function(response) {
                        console.log('전송 완료');
                        console.log('응답:', response);
                    },
                    error: function(error) {
                        console.log('전송 실패', selectedValues);
                        console.log('전송 실패');
                        console.log('에러:', error);
                    }
                });
            }
        }
    }
});
