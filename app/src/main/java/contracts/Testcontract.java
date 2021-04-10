package contracts;

import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tuples.generated.Tuple4;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class Testcontract extends Contract {
    public static final String BINARY = "60806040526000805534801561001457600080fd5b50611254806100246000396000f3fe608060405234801561001057600080fd5b50600436106100885760003560e01c8063795f54351161005b578063795f54351461011357806394124d431461012f578063a8e70eb014610162578063b2c21c011461019457610088565b80630a56de971461008d57806334bf4ade146100a95780635e6a0e7d146100db57806368546d1f146100f7575b600080fd5b6100a760048036038101906100a29190610c9a565b6101c7565b005b6100c360048036038101906100be9190610c71565b610324565b6040516100d293929190610ead565b60405180910390f35b6100f560048036038101906100f09190610c0a565b61045e565b005b610111600480360381019061010c9190610c9a565b6105e4565b005b61012d60048036038101906101289190610d19565b61063f565b005b61014960048036038101906101449190610c71565b610724565b6040516101599493929190610ef2565b60405180910390f35b61017c60048036038101906101779190610d94565b6107fc565b60405161018b93929190610ead565b60405180910390f35b6101ae60048036038101906101a99190610d94565b610953565b6040516101be9493929190610ef2565b60405180910390f35b600015156001600085815260200190815260200160002060009054906101000a900460ff1615151461022e576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161022590610e8d565b60405180910390fd5b604051806060016040528084815260200183815260200182815250600a600082015181600001556020820151816001019080519060200190610271929190610a48565b50604082015181600201908051906020019061028e929190610a48565b50905050600a600360008581526020019081526020016000206000820154816000015560018201816001019080546102c59061102e565b6102d0929190610ace565b5060028201816002019080546102e59061102e565b6102f0929190610ace565b50905050600180600085815260200190815260200160002060006101000a81548160ff021916908315150217905550505050565b600360205280600052604060002060009150905080600001549080600101805461034d9061102e565b80601f01602080910402602001604051908101604052809291908181526020018280546103799061102e565b80156103c65780601f1061039b576101008083540402835291602001916103c6565b820191906000526020600020905b8154815290600101906020018083116103a957829003601f168201915b5050505050908060020180546103db9061102e565b80601f01602080910402602001604051908101604052809291908181526020018280546104079061102e565b80156104545780601f1061042957610100808354040283529160200191610454565b820191906000526020600020905b81548152906001019060200180831161043757829003601f168201915b5050505050905083565b604051806080016040528060005481526020018481526020018381526020018273ffffffffffffffffffffffffffffffffffffffff1681525060066000820151816000015560208201518160010190805190602001906104bf929190610a48565b506040820151816002015560608201518160030160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550905050600660026000805481526020019081526020016000206000820154816000015560018201816001019080546105489061102e565b610553929190610ace565b50600282015481600201556003820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff168160030160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055509050506000808154809291906105da90611091565b9190505550505050565b8160036000858152602001908152602001600020600101908051906020019061060e929190610a48565b5080600360008581526020019081526020016000206002019080519060200190610639929190610a48565b50505050565b6000548411610683576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161067a90610e6d565b60405180910390fd5b826002600086815260200190815260200160002060010190805190602001906106ad929190610a48565b50816002600086815260200190815260200160002060020181905550806002600086815260200190815260200160002060030160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050505050565b600260205280600052604060002060009150905080600001549080600101805461074d9061102e565b80601f01602080910402602001604051908101604052809291908181526020018280546107799061102e565b80156107c65780601f1061079b576101008083540402835291602001916107c6565b820191906000526020600020905b8154815290600101906020018083116107a957829003601f168201915b5050505050908060020154908060030160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905084565b6005602052816000526040600020818154811061081857600080fd5b9060005260206000209060030201600091509150508060000154908060010180546108429061102e565b80601f016020809104026020016040519081016040528092919081815260200182805461086e9061102e565b80156108bb5780601f10610890576101008083540402835291602001916108bb565b820191906000526020600020905b81548152906001019060200180831161089e57829003601f168201915b5050505050908060020180546108d09061102e565b80601f01602080910402602001604051908101604052809291908181526020018280546108fc9061102e565b80156109495780601f1061091e57610100808354040283529160200191610949565b820191906000526020600020905b81548152906001019060200180831161092c57829003601f168201915b5050505050905083565b6004602052816000526040600020818154811061096f57600080fd5b9060005260206000209060040201600091509150508060000154908060010180546109999061102e565b80601f01602080910402602001604051908101604052809291908181526020018280546109c59061102e565b8015610a125780601f106109e757610100808354040283529160200191610a12565b820191906000526020600020905b8154815290600101906020018083116109f557829003601f168201915b5050505050908060020154908060030160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905084565b828054610a549061102e565b90600052602060002090601f016020900481019282610a765760008555610abd565b82601f10610a8f57805160ff1916838001178555610abd565b82800160010185558215610abd579182015b82811115610abc578251825591602001919060010190610aa1565b5b509050610aca9190610b5b565b5090565b828054610ada9061102e565b90600052602060002090601f016020900481019282610afc5760008555610b4a565b82601f10610b0d5780548555610b4a565b82800160010185558215610b4a57600052602060002091601f016020900482015b82811115610b49578254825591600101919060010190610b2e565b5b509050610b579190610b5b565b5090565b5b80821115610b74576000816000905550600101610b5c565b5090565b6000610b8b610b8684610f63565b610f3e565b905082815260208101848484011115610ba357600080fd5b610bae848285610fec565b509392505050565b600081359050610bc5816111f0565b92915050565b600082601f830112610bdc57600080fd5b8135610bec848260208601610b78565b91505092915050565b600081359050610c0481611207565b92915050565b600080600060608486031215610c1f57600080fd5b600084013567ffffffffffffffff811115610c3957600080fd5b610c4586828701610bcb565b9350506020610c5686828701610bf5565b9250506040610c6786828701610bb6565b9150509250925092565b600060208284031215610c8357600080fd5b6000610c9184828501610bf5565b91505092915050565b600080600060608486031215610caf57600080fd5b6000610cbd86828701610bf5565b935050602084013567ffffffffffffffff811115610cda57600080fd5b610ce686828701610bcb565b925050604084013567ffffffffffffffff811115610d0357600080fd5b610d0f86828701610bcb565b9150509250925092565b60008060008060808587031215610d2f57600080fd5b6000610d3d87828801610bf5565b945050602085013567ffffffffffffffff811115610d5a57600080fd5b610d6687828801610bcb565b9350506040610d7787828801610bf5565b9250506060610d8887828801610bb6565b91505092959194509250565b60008060408385031215610da757600080fd5b6000610db585828601610bf5565b9250506020610dc685828601610bf5565b9150509250929050565b610dd981610fb0565b82525050565b6000610dea82610f94565b610df48185610f9f565b9350610e04818560208601610ffb565b610e0d81611167565b840191505092915050565b6000610e25602383610f9f565b9150610e3082611178565b604082019050919050565b6000610e48601b83610f9f565b9150610e53826111c7565b602082019050919050565b610e6781610fe2565b82525050565b60006020820190508181036000830152610e8681610e18565b9050919050565b60006020820190508181036000830152610ea681610e3b565b9050919050565b6000606082019050610ec26000830186610e5e565b8181036020830152610ed48185610ddf565b90508181036040830152610ee88184610ddf565b9050949350505050565b6000608082019050610f076000830187610e5e565b8181036020830152610f198186610ddf565b9050610f286040830185610e5e565b610f356060830184610dd0565b95945050505050565b6000610f48610f59565b9050610f548282611060565b919050565b6000604051905090565b600067ffffffffffffffff821115610f7e57610f7d611138565b5b610f8782611167565b9050602081019050919050565b600081519050919050565b600082825260208201905092915050565b6000610fbb82610fc2565b9050919050565b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b6000819050919050565b82818337600083830152505050565b60005b83811015611019578082015181840152602081019050610ffe565b83811115611028576000848401525b50505050565b6000600282049050600182168061104657607f821691505b6020821081141561105a57611059611109565b5b50919050565b61106982611167565b810181811067ffffffffffffffff8211171561108857611087611138565b5b80604052505050565b600061109c82610fe2565b91507fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff8214156110cf576110ce6110da565b5b600182019050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601160045260246000fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b6000601f19601f8301169050919050565b7f50617469656e74207769746820676976656e20494420646f65736e277420657860008201527f6973740000000000000000000000000000000000000000000000000000000000602082015250565b7f596f75206861766520616c726561647920726567697374657265640000000000600082015250565b6111f981610fb0565b811461120457600080fd5b50565b61121081610fe2565b811461121b57600080fd5b5056fea2646970667358221220c03dd770f7e76d4d5f3e69afa4d6ff3b478ca6de0db48b0045559ad7526ad57364736f6c63430008030033\r\n";

    public static final String FUNC_CREATEDOCTOR = "createDoctor";

    public static final String FUNC_CREATEPATIENT = "createPatient";

    public static final String FUNC_DDATALIST = "dDataList";

    public static final String FUNC_DMAP = "dMap";

    public static final String FUNC_PDATALIST = "pDataList";

    public static final String FUNC_PMAP = "pMap";

    public static final String FUNC_UPDATEDOCTOR = "updateDoctor";

    public static final String FUNC_UPDATEPATIENT = "updatePatient";

    @Deprecated
    protected Testcontract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Testcontract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Testcontract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Testcontract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> createDoctor(BigInteger _license, String _name, String _hospital) {
        final Function function = new Function(
                FUNC_CREATEDOCTOR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_license), 
                new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.Utf8String(_hospital)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> createPatient(String _name, BigInteger _adhar, String _account_address) {
        final Function function = new Function(
                FUNC_CREATEPATIENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.generated.Uint256(_adhar), 
                new org.web3j.abi.datatypes.Address(160, _account_address)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple3<BigInteger, String, String>> dDataList(BigInteger param0, BigInteger param1) {
        final Function function = new Function(FUNC_DDATALIST, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0), 
                new org.web3j.abi.datatypes.generated.Uint256(param1)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteFunctionCall<Tuple3<BigInteger, String, String>>(function,
                new Callable<Tuple3<BigInteger, String, String>>() {
                    @Override
                    public Tuple3<BigInteger, String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<BigInteger, String, String>(
                                (BigInteger) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue());
                    }
                });
    }

    public RemoteFunctionCall<Tuple3<BigInteger, String, String>> dMap(BigInteger param0) {
        final Function function = new Function(FUNC_DMAP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteFunctionCall<Tuple3<BigInteger, String, String>>(function,
                new Callable<Tuple3<BigInteger, String, String>>() {
                    @Override
                    public Tuple3<BigInteger, String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<BigInteger, String, String>(
                                (BigInteger) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue());
                    }
                });
    }

    public RemoteFunctionCall<Tuple4<BigInteger, String, BigInteger, String>> pDataList(BigInteger param0, BigInteger param1) {
        final Function function = new Function(FUNC_PDATALIST, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0), 
                new org.web3j.abi.datatypes.generated.Uint256(param1)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}));
        return new RemoteFunctionCall<Tuple4<BigInteger, String, BigInteger, String>>(function,
                new Callable<Tuple4<BigInteger, String, BigInteger, String>>() {
                    @Override
                    public Tuple4<BigInteger, String, BigInteger, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<BigInteger, String, BigInteger, String>(
                                (BigInteger) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (String) results.get(3).getValue());
                    }
                });
    }

    public RemoteFunctionCall<Tuple4<BigInteger, String, BigInteger, String>> pMap(BigInteger param0) {
        final Function function = new Function(FUNC_PMAP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}));
        return new RemoteFunctionCall<Tuple4<BigInteger, String, BigInteger, String>>(function,
                new Callable<Tuple4<BigInteger, String, BigInteger, String>>() {
                    @Override
                    public Tuple4<BigInteger, String, BigInteger, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<BigInteger, String, BigInteger, String>(
                                (BigInteger) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (String) results.get(3).getValue());
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> updateDoctor(BigInteger _license, String _name, String _hospital) {
        final Function function = new Function(
                FUNC_UPDATEDOCTOR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_license), 
                new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.Utf8String(_hospital)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> updatePatient(BigInteger _id, String _name, BigInteger _adhar, String _account_address) {
        final Function function = new Function(
                FUNC_UPDATEPATIENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_id), 
                new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.generated.Uint256(_adhar), 
                new org.web3j.abi.datatypes.Address(160, _account_address)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Testcontract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Testcontract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Testcontract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Testcontract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Testcontract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Testcontract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Testcontract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Testcontract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Testcontract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Testcontract.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Testcontract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Testcontract.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Testcontract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Testcontract.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Testcontract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Testcontract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
