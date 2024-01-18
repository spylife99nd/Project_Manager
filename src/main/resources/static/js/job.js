var currentPage = 0;
var totalPage = 0;
var totalElements = 0;
var numberOfElements = 0;
const bindingDataTable = (url) => {
    $.ajax({
        url: url,
        method: "GET",
        dataType: "json"
    }).done((response) => {
        let tableRows = " ";
        if (response.content.length > 0) {
            totalPage = response.totalPages;
            totalElements = response.totalElements;
            numberOfElements = response.numberOfElements;
            response.content.forEach((jobDto) => {
                tableRows += `
                            <tr>
                              <td>${jobDto.title}</td>
                              <td>${jobDto.skillsList}</td>
                              <td>${jobDto.startDate}</td>
                              <td>${jobDto.endDate}</td>
                              <td>${jobDto.levelList}</td>
                              <td>${jobDto.status}</td>
                              <td>
                                <a href="#">
                                  <i class="fa-regular fa-eye"></i></a>
                                <a href="#">
                                  <i class="fa-regular fa-pen-to-square"></i>
                                </a>
                                <a class="text-danger" href="#">
                                 <i class="fa-solid fa-trash"></i>
                                </a>
                              </td>
                            </tr>`;
            });
            $('tbody').html(tableRows);
        } else {
            $('tbody').html('<tr><td colspan="7">No item matches with your search data. Please try again.</td></tr>');
        }
        updatePaginationInfo();
    })
        .fail((xhr, status, error) => {
            console.error(`AJAX request failed. Status: ${status}, Error: ${error}`);
        })
        .always(() => {

        })
}


document.getElementById("searchButton").addEventListener("click", function (event) {
    event.preventDefault()
    let searchText = document.getElementById("formSearch").value;
    var selectElement = document.getElementById("mySelect").value;

    if (searchText !== '' && selectElement === 'Select') {
        bindingDataTable(`/job/api/v1?keyword=${searchText}`);
    } else if (searchText === '' && selectElement !== 'Select') {
        bindingDataTable(`/job/api/v1?status=${selectElement}`);
    } else if (searchText !== '' && selectElement !== '') {
        bindingDataTable(`/job/api/v1?keyword=${searchText}&status=${selectElement}`);
    } else {
        bindingDataTable("/job/api/v1");
    }
});

function updatePaginationInfo() {
    $('#zero_config_info').text(`${numberOfElements} / ${totalElements} rows`);
}

$('#nextBtn').click(function () {
    if (currentPage < totalPage - 1) {
        currentPage++;
        bindingDataTable(`/job/api/v1?pageIndex=${currentPage}`);
        $('#prevBtn').prop('disable', false);
    } else {
        console.log("You are on the last page");
        $('#nextBtn').prop('disabled', true);
    }
});

$('#prevBtn').click(function () {
    if (currentPage > 0) {
        currentPage--;
        bindingDataTable(`/job/api/v1?pageIndex=${currentPage}`);
        $('#nextBtn').prop('disabled', false);
    } else {
        console.log("You are on the first page");
        $('#prevBtn').prop('disabled', true);
    }
});


bindingDataTable("/job/api/v1");
