/**
 * Created by akjonca on 2/18/17.
 */
$(document).ready(main);

function main() {
    $('.btn-collapse').click(function (e) {
        e.preventDefault();
        var $this = $(this);
        var $collapse = $this.closest('.collapse-group').find('.collapse');
        $collapse.collapse('toggle');
    });
}
