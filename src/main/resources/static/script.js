async function getFile1Hash(){
    try{
        //首先获取文件1的名称
        const response = await fetch('http://localhost:8192/api/get_file1_name', {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            },
        });
        const result = await response.json();
        const file1Name = result.data;
        console.log("文件1名称:",file1Name);
        const File1Hash = await submitFileName(file1Name);
        console.log("文件1哈希值:", File1Hash);
        // 将哈希值放到文本框
        document.getElementById("hashBox1").value = File1Hash;
    } catch (error){
        console.error("请求错误:",error);
    }
}
async function getFile2Hash(){
    try{
        //首先获取文件2的名称
        const response = await fetch('http://localhost:8192/api/get_file2_name', {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            },
        });
        const result = await response.json();
        const file2Name = result.data;
        console.log("文件2名称:",file2Name);
        const File2Hash = await submitFileName(file2Name);
        console.log("文件2哈希值:", File2Hash);
        // 将哈希值放到文本框
        document.getElementById("hashBox2").value = File2Hash;
    } catch (error){
        console.error("请求错误:",error);
    }
}
async function getFile3Hash(){
    try{
        //首先获取文件2的名称
        const response = await fetch('http://localhost:8192/api/get_file3_name', {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            },
        });
        const result = await response.json();
        const file3Name = result.data;
        console.log("文件3名称:",file3Name);
        const File3Hash = await submitFileName(file3Name);
        console.log("文件3哈希值:", File3Hash);
        // 将哈希值放到文本框
        document.getElementById("hashBox3").value = File3Hash;
    } catch (error){
        console.error("请求错误:",error);
    }
}
async function getMergerHash(){
    try{
        //首先获取文件2的名称
        const response = await fetch('http://localhost:8192/api/get_merger_name', {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            },
        });
        const result = await response.json();
        const fileMergerName = result.data;
        console.log("合并器名称:",fileMergerName);
        const FileMergerHash = await submitFileName(fileMergerName);
        console.log("合并器哈希值:", FileMergerHash);
        // 将哈希值放到文本框
        document.getElementById("hashBoxMerger").value = FileMergerHash;
    } catch (error){
        console.error("请求错误:",error);
    }
}
async function submitFileName(fileName) {
    try {
        const dict = {
        };
        dict['fileName'] = fileName;
        const response = await fetch('http://localhost:8192/api/submit_file', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(dict)
        });
        const result = await response.json();
        console.log(result.status);
        console.log(result.message);
        console.log(result.data);
        return result.data;
    } catch (error) {
        console.error('请求错误:', error);
        return "error";
    }
}

