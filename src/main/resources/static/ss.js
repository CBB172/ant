$(function(){
    // 定义全局变量
    var globalVar = {
        viewFlag:0 ,    //0-显示裁减框，1-显示裁减之后的图片
        timeBtnArr:[$('#1'),$('#2'),$('#3')]
    };
    // 生成裁减对象的属性设置
    var options ={
        thumbBox: '.thumbBox',  //显示裁减的框内容
        spinner: '.spinner',    //裁减框要是没有图片，则显示
        // imgSrc: 'style1.png'
    };

    // 生成裁减对象
    var cropper = $('.imageBox').cropbox(options);

    // 上传图像
    $('#image').on('change', function(){
        var reader = new FileReader();
        globalVar.viewFlag = 0;
        refreshImgView();
        reader.onload = function(e) {
            options.imgSrc = e.target.result;
            cropper = $('#imageBox').cropbox(options);
        }
        reader.readAsDataURL(this.files[0]);
    });

    // 点击裁减按钮,生成裁减之后的图片,并显示裁减之后的图片
    $('#btnCrop').on('click', function(){
        // 裁减生成图片的url
        var imgSrc = cropper.getDataURL();
        $('#cropImg').attr('src',imgSrc);
        globalVar.viewFlag = 1;
        refreshImgView();
    });

    // 裁减框和裁减之后图片的显示于隐藏
    function refreshImgView(){
        if( globalVar.viewFlag == 0 ){
            // 显示裁剪框
            $('#imageBox').show();
            $('#cropped').hide();
        }else{
            // 显示裁减之后的图片
            $('#imageBox').hide();
            $('#cropped').show();
        }
    }

    // 点击缩小按钮
    $('#btnZoomIn').on('click', function(){
        cropper.zoomIn();
    });

    // 点击放大按钮
    $('#btnZoomOut').on('click', function(){
        cropper.zoomOut();
    });


    $('#1').click(function(){
        if( $(this).hasClass('selectTimeCss') ){

        }else{
            refreshTimeBtnView($('#1'));
        }
    });

    // 点击paScreentime2
    $('#2').click(function(){
        if( $(this).hasClass('selectTimeCss') ){

        }else{
            refreshTimeBtnView($('#2'));
        }
    });

    // 点击paScreentime2
    $('#3').click(function(){
        if( $(this).hasClass('selectTimeCss') ){

        }else{
            refreshTimeBtnView($('#3'));
        }
    });

    // 给选中的时间添加样式，未选中的是默认样式
    function refreshTimeBtnView(obj){
        var id = obj.attr('id');
        var arr = globalVar.timeBtnArr;
        var len = arr.length;
        for(var i = 0;i<len; i++){
            var oldId = '';
            if( arr[i].hasClass('selectTimeCss') ){
                oldId = arr[i].attr('id');
                arr[i].removeClass('selectTimeCss');
                $('#checkIcon'+ oldId).css('display','none');
            }
        }
        obj.addClass('selectTimeCss');
        $('#checkIcon'+id).css('display','block');
    }

});
