//***************Navigation page***************//
function goPage(url) {
    console.log('Click success');
    $.ajax({
        url: url,
        type: 'GET',
        success: function (response) {
            console.log('Sidebar success', url);
            $('#root').html(response);
        },
        error: function (response) {
            console.log('Sidebar error', url);
        }
    })
}

function goModeratorManager() {
    console.log('Hahahahaha');
    var url = 'moderator-manager.htm';
    goPage(url);
}

function goCatalogManager() {
    var url = 'catalog-manager.htm';
    goPage(url);
}

function goCatalogInsert() {
    var url = 'catalog-goinsert.htm';
    goPage(url);
}

function goProductManager() {
    var url = 'product-manager.htm';
    goPage(url);
}

function goProductInsert() {
    var url = 'product-goinsert.htm';
    goPage(url);
}

function goError() {
    var url = 'error.htm';
    goPage(url);
}

$(document).ready(function () {
    //Catalog manager
    $('#sidebar-catalog-manager').click(function (e) {
        e.preventDefault();
        goCatalogManager();
    })
    //Catalog insert
    $('#sidebar-catalog-insert').click(function (e) {
        e.preventDefault();
        goCatalogInsert();
    })
    //Catalog manager
    $('#sidebar-product-manager').click(function (e) {
        e.preventDefault();
        goProductManager();
    })
    //Catalog insert
    $('#sidebar-product-insert').click(function (e) {
        e.preventDefault();
        goProductInsert();
    })
    //Moderator manager
    $('#sidebar-moderator-manager').click(function (e) {
        console.log('Hahahahaha');
        e.preventDefault();
        goModeratorManagers();
    })
});

//***************Product***************//
function initDataStatusProduct(productId, status) {
    if (typeof status !== 'boolean')
        return;
    document.getElementById('product-status-' + productId).innerHTML = (status == true) ? "Kích hoạt" : "Không kích hoạt";
    document.getElementById('product-status-' + productId).className = (status == true) ? "" : "text-danger";
    document.getElementById('product-toggle-' + productId).className = "btn btn-action " + ((status == true) ? "btn-secondary" : "btn-success");
}

function onClickDeleteProduct(productId) {
    $.ajax({
        url: 'product_delete.htm?productId=' + productId,
        type: 'GET',
        dataType: 'json',
        success: function (result) {
            console.log('Delete output', result);
            var check = result.delete_result;
            if (typeof check === 'boolean' && check) {
                var element = document.getElementById('product-item-' + productId);
                element.parentNode.removeChild(element);
            }
        },
        error: function (result) {
            console.log('Error output', result);
        }
    })
}

function onClickToggleProduct(productId) {
    $.ajax({
        url: 'product_toggle.htm?productId=' + productId,
        type: 'GET',
        dataType: 'json',
        success: function (result) {
            console.log('Success', result);
            var status = result.status;
            if (typeof status === 'boolean') {
                console.log("Success:", $("#product-status" + productId));
                initDataStatusProduct(productId, status);
            }
        },
        error: function (result) {
            console.log('Error', result);
        }
    })
}

function onClickEditProduct(productId) {
    var url = 'product-goedit.htm?productId=' + productId;
    goPage(url);
}

//***************Catalog***************//
function initDataStatusCatalog(catalogId, status) {
    if (typeof status !== 'boolean')
        return;
    document.getElementById('catalog-status-' + catalogId).innerHTML = (status == true) ? "Kích hoạt" : "Không kích hoạt";
    document.getElementById('catalog-status-' + catalogId).className = (status == true) ? "" : "text-danger";
    document.getElementById('catalog-toggle-' + catalogId).className = "btn btn-action " + ((status == true) ? "btn-secondary" : "btn-success");
}

function onClickDeleteCatalog(catalogId) {
    $.ajax({
        url: 'catalog_delete.htm?catalogId=' + catalogId,
        type: 'GET',
        dataType: 'json',
        success: function (result) {
            console.log('Delete output', result);
            var check = result.delete_result;
            if (typeof check === 'boolean' && check) {
                var element = document.getElementById('catalog-item-' + catalogId);
                element.parentNode.removeChild(element);
            }
        },
        error: function (result) {
            console.log('Error output', result);
        }
    })
}

function onClickToggleCatalog(catalogId) {
    $.ajax({
        url: 'catalog_toggle.htm?catalogId=' + catalogId,
        type: 'GET',
        dataType: 'json',
        success: function (result) {
            console.log('Success', result);
            var status = result.status;
            if (typeof status === 'boolean') {
                console.log("Success:", $("#catalog-status" + catalogId));
                initDataStatusCatalog(catalogId, status);
            }
        },
        error: function (result) {
            console.log('Error', result);
        }
    })
}

function onClickEditCatalog(catalogId) {
    var url = 'catalog-goedit.htm?catalogId=' + catalogId;
    goPage(url);
}
