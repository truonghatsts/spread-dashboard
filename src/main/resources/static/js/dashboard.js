dashboard = {
    hideAll: function () {
        $("#datatable").hide();
        $("#npChart").hide();
        $("#wpChart").hide();
    },
    showDatatable: function () {
        dashboard.hideAll();
        $("#datatable").show();
        Cookies.set("view", "data");
    },
    showChart: function () {
        dashboard.hideAll();
        $("#npChart").show();
        $("#wpChart").show();
        Cookies.set("view", "chart");
    }
};