$(document).ready(function() {
    // "checkAll" 체크박스에 클릭 이벤트 핸들러를 추가합니다.
    $('#checkAll').click(function() {
        var isChecked = $(this).is(':checked');

        // "tbody"에 있는 모든 체크박스를 선택 혹은 해제합니다.
        $('tbody .myCheckbox').prop('checked', isChecked);
    });
});



